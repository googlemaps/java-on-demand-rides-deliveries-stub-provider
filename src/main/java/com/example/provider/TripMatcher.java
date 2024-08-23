/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.provider;

import static java.util.stream.Collectors.toList;

import com.example.provider.auth.grpcservice.AuthenticatedGrpcServiceProvider;
import com.example.provider.utils.TripUtils;
import com.google.inject.Inject;
import com.google.protobuf.FieldMask;
import google.maps.fleetengine.v1.GetTripRequest;
import google.maps.fleetengine.v1.TerminalLocation;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.TripServiceClient;
import google.maps.fleetengine.v1.TripStatus;
import google.maps.fleetengine.v1.TripType;
import google.maps.fleetengine.v1.TripWaypoint;
import google.maps.fleetengine.v1.UpdateTripRequest;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.VehicleState;
import google.maps.fleetengine.v1.WaypointType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Singleton;

/** Utility class that matches vehicles with trips based on a number of conditions/state. */
@Singleton
class TripMatcher {

  private final TripServiceClient authenticatedServerTripService;
  private final ServletState servletState;

  private static final Logger logger = Logger.getLogger(TripMatcher.class.getName());

  @Inject
  public TripMatcher(
      AuthenticatedGrpcServiceProvider grpcServiceProvider, ServletState servletState) {
    this.authenticatedServerTripService = grpcServiceProvider.getAuthenticatedTripService();
    this.servletState = servletState;
  }

  /** Determines if the given vehicle is ready to take a match based on current state. */
  private synchronized boolean canTripBeAssignedToVehicle(Vehicle vehicle, Trip tripToMatch) {
    List<TripType> vehicleSupportedTripTypes = vehicle.getSupportedTripTypesList();
    TripType tripType = tripToMatch.getTripType();

    if (!vehicleSupportedTripTypes.contains(tripType)) {
      logger.warning(
              String.format(
                      "canTripBeAssignedToVehicle() returning false due to tripType not supported: for vehicleId: %s tripName: %s",
                      vehicle.getName(), tripToMatch.getName()));
      return false;
    }

    int numberOfTripsAssigned = vehicle.getCurrentTripsList().size();

    if (numberOfTripsAssigned == 0) {
      return true;
    }

    /**
     * If both vehicle and trip support 'Shared pool', always match as long as there's capacity. We
     * only compare 'Vehicle maximum capacity' vs 'Trip number of passengers' the 'waypoints
     * computation logic will only try to insert the 'Trip' at a given point if there's capacity.
     * That means, that in case the 'Vehicle maximum capacity' equals 'Trip number of passengers',
     * the 'Trip will be added at the end of the 'waypoints' list.
     */
    boolean vehicleSupportsSharedTrips = vehicleSupportedTripTypes.contains(TripType.SHARED);
    boolean isTripMatchShareable = tripType == TripType.SHARED;

    if (vehicleSupportsSharedTrips
        && isTripMatchShareable
        && vehicle.getMaximumCapacity() >= tripToMatch.getNumberOfPassengers()) {
      return true;
    }

    /**
     * In case there's more than 1 trip assigned to the 'Vehicle' and there's no 'Shared pool'
     * supported, then provider will try to assign as 'B2B' trip.
     */
    if (numberOfTripsAssigned >= 2) {
      logger.warning(
              String.format(
                      "canTripBeAssignedToVehicle() returning false due to numberOfTripsAssigned %s: vehicleId: %s tripName: %s",
                      numberOfTripsAssigned, vehicle.getName(), tripToMatch.getName()));
      return false;
    }

    if (vehicle.getBackToBackEnabled() == false) {
      logger.warning(
              String.format(
                      "canTripBeAssignedToVehicle() returning false due to backToBackEnabled not enabled on vehicleId: %s tripName: %s",
                      vehicle.getName(), tripToMatch.getName()));
      return false;
    }

    Trip currentTrip = servletState.getActiveTripsMap().get(vehicle.getCurrentTripsList().get(0));

    GetTripRequest getTripRequest =
        GetTripRequest.newBuilder().setName(currentTrip.getName()).build();

    Trip trip = authenticatedServerTripService.getTrip(getTripRequest);

    /** For B2B trips, only trigger match is the 'Vehicle active trip' is beyond 'PICKUP'. */
    return trip.getTripStatus() != TripStatus.ENROUTE_TO_PICKUP
        && trip.getTripStatus() != TripStatus.ARRIVED_AT_PICKUP
        && trip.getTripStatus() != TripStatus.NEW;
  }

  /** Tries to match the 'next trip' in the pending matches list to the active 'Vehicle'. */
  public synchronized boolean triggerMatching(Vehicle vehicle, String vehicleId) {
    if (vehicle.getVehicleState() != VehicleState.ONLINE) {
      logger.warning(
              String.format(
                      "triggerMatching() returning false because of vehicleState not being ONLINE: vehicleId: %s vehicleState: %s",
                      vehicleId, vehicle.getVehicleState()));
      return false;
    }

    Trip tripToMatch = null;

    for (Trip trip : servletState.getTripsPendingMatches()) {
      if (canTripBeAssignedToVehicle(vehicle, trip)) {
        tripToMatch = trip;
        break;
      }
    }

    if (tripToMatch == null) {
      logger.warning(
              String.format(
                      "triggerMatching() returning false due to tripToMatch being null: vehicleId: %s", vehicleId));
      return false;
    }

    logger.info(
        String.format(
            "triggerMatching() vehicleId: %s tripName: %s", vehicleId, tripToMatch.getName()));

    String tripToMatchId = TripUtils.getTripIdFromName(tripToMatch.getName());
    UpdateTripRequest updateRequest;

    int insertIndex = getIndexForTripInsertion(vehicle, tripToMatch);

    /**
     * If the insertIndex is greater or equal than zero, that means provider will try to create a
     * 'Shared pool' for the 'Trip'. Otherwise, it will not explicitly set 'VehicleWaypoints' and
     * will let 'FleetEngine' assign the trip to the end of the 'waypoints' list.
     */
    if (insertIndex >= 0) {
      List<TripWaypoint> computedVehicleWaypoints =
          getComputedWaypointsForSharedPool(vehicle, tripToMatch, tripToMatchId, insertIndex);

      updateRequest =
          UpdateTripRequest.newBuilder()
              .setName(tripToMatch.getName())
              .setTrip(
                  Trip.newBuilder()
                      .setVehicleId(vehicleId)
                      .addAllVehicleWaypoints(computedVehicleWaypoints)
                      .build())
              .setUpdateMask(
                  FieldMask.newBuilder()
                      .addPaths("vehicle_id")
                      .addPaths("vehicle_waypoints")
                      .build())
              .build();
    } else {
      updateRequest =
          UpdateTripRequest.newBuilder()
              .setName(tripToMatch.getName())
              .setTrip(Trip.newBuilder().setVehicleId(vehicleId).build())
              .setUpdateMask(FieldMask.newBuilder().addPaths("vehicle_id").build())
              .build();
    }

    Trip updatedTrip = authenticatedServerTripService.updateTrip(updateRequest);
    servletState.getActiveTripsMap().put(updatedTrip.getName(), updatedTrip);
    servletState.removeTripPendingMatch(tripToMatch); // Trip assigned, no longer pending.

    logger.info(
        String.format(
            "triggerMatching() completed vehicleId: %s tripName: %s",
            vehicleId, tripToMatch.getName()));

    return true;
  }

  /**
   * In case it has been determined that the 'Trip' to match will be part of a 'Shared pool', this
   * method then is responsible for creating a 'waypoints' list where the given 'Trip' waypoints
   * will be inserted (position is given by `insertIndex`).
   */
  private static synchronized List<TripWaypoint> getComputedWaypointsForSharedPool(
      Vehicle vehicle, Trip tripToMatch, String tripToMatchId, int insertIndex) {
    List<TripWaypoint> vehicleWaypoints = vehicle.getWaypointsList();
    List<TripWaypoint> computedVehicleWaypoints = new ArrayList<>();
    computedVehicleWaypoints.addAll(vehicleWaypoints.subList(0, insertIndex));

    computedVehicleWaypoints.add(
        TripWaypoint.newBuilder()
            .setLocation(tripToMatch.getPickupPoint())
            .setTripId(tripToMatchId)
            .setWaypointType(WaypointType.PICKUP_WAYPOINT_TYPE)
            .build());

    computedVehicleWaypoints.add(vehicleWaypoints.get(insertIndex));

    List<TerminalLocation> intermediateDestinationsList =
        tripToMatch.getIntermediateDestinationsList();

    List<TripWaypoint> intermediateDestinationWaypoints =
        intermediateDestinationsList
            .stream()
            .map(
                location ->
                    TripWaypoint.newBuilder()
                        .setLocation(location)
                        .setTripId(tripToMatchId)
                        .setWaypointType(WaypointType.INTERMEDIATE_DESTINATION_WAYPOINT_TYPE)
                        .build())
            .collect(toList());

    computedVehicleWaypoints.addAll(intermediateDestinationWaypoints);

    computedVehicleWaypoints.add(
        TripWaypoint.newBuilder()
            .setLocation(tripToMatch.getDropoffPoint())
            .setTripId(tripToMatchId)
            .setWaypointType(WaypointType.DROP_OFF_WAYPOINT_TYPE)
            .build());

    computedVehicleWaypoints.addAll(
        vehicleWaypoints.subList(insertIndex + 1, vehicleWaypoints.size()));

    return computedVehicleWaypoints;
  }

  /**
   * Calculates the index at where a 'Trip' could be inserted to create a 'Shared pool'. The
   * provider will try to insert the 'Trip' in before the last 'dropoff' waypoint where there is
   * capacity. It is worth noting that this might not be the optimal order but works for
   * demonstration purpose. In practice, the implementation should take in consideration resources
   * such as: time, distance.
   *
   * @return Returns a -1 if the 'Trip' should be inserted at the end of the waypoints list (B2B or
   *     Exclusive). Otherwise, returns the index (based on the 'vehicleWaypoints') where the 'Trip'
   *     could be inserted.
   */
  private synchronized int getIndexForTripInsertion(Vehicle vehicle, Trip tripToMatch) {
    if (tripToMatch.getTripType() != TripType.SHARED) {
      return -1;
    }

    if (!vehicle.getSupportedTripTypesList().contains(TripType.SHARED)) {
      return -1;
    }

    List<String> currentTrips = vehicle.getCurrentTripsList();

    if (currentTrips.isEmpty()) {
      return -1;
    }

    int numberOfPassengers = 0;

    // Calculate number of passengers currently in the vehicle (have already been picked up).
    for (String tripId : currentTrips) {
      Trip trip = servletState.getTrip(tripId);

      boolean isTripPassengerPickedUp =
          trip.getTripStatus() == TripStatus.ENROUTE_TO_DROPOFF
              || trip.getTripStatus() == TripStatus.ENROUTE_TO_INTERMEDIATE_DESTINATION
              || trip.getTripStatus() == TripStatus.ARRIVED_AT_INTERMEDIATE_DESTINATION;

      if (isTripPassengerPickedUp) {
        numberOfPassengers += trip.getNumberOfPassengers();
      }
    }

    List<TripWaypoint> vehicleWaypoints = vehicle.getWaypointsList();

    int insertIndex = -1;
    int iterationIndex = 0;

    /**
     * Calculate the number of passengers that will be in the car after every 'waypoint'. It then
     * finds the last 'Dropoff' waypoint where 'Trip' can be inserted.
     */
    for (TripWaypoint waypoint : vehicleWaypoints) {
      Trip waypointTrip = servletState.getTrip(waypoint.getTripId());

      if (waypoint.getWaypointType() == WaypointType.PICKUP_WAYPOINT_TYPE) {
        numberOfPassengers += waypointTrip.getNumberOfPassengers();
      } else if (waypoint.getWaypointType() == WaypointType.DROP_OFF_WAYPOINT_TYPE) {
        boolean isThereVehicleCapacity =
            (numberOfPassengers + tripToMatch.getNumberOfPassengers())
                <= vehicle.getMaximumCapacity();

        if (tripToMatch.getTripType() == TripType.SHARED && isThereVehicleCapacity) {
          insertIndex = iterationIndex;
        }

        numberOfPassengers -= waypointTrip.getNumberOfPassengers();
      }

      iterationIndex++;
    }

    return insertIndex;
  }
}
