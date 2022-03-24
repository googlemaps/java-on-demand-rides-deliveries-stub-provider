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

import com.example.provider.auth.grpcservice.AuthenticatedGrpcServiceProvider;
import com.example.provider.utils.VehicleUtils;
import com.google.inject.Inject;
import com.google.protobuf.FieldMask;
import google.maps.fleetengine.v1.GetTripRequest;
import google.maps.fleetengine.v1.GetVehicleRequest;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.TripServiceClient;
import google.maps.fleetengine.v1.TripStatus;
import google.maps.fleetengine.v1.UpdateTripRequest;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.VehicleServiceClient;
import java.util.logging.Logger;
import javax.inject.Singleton;

/** Utility class that matches vehicles with trips based on a number of conditions/state. */
@Singleton
class TripMatcher {

  private final TripServiceClient authenticatedServerTripService;
  private final VehicleServiceClient authenticatedServerVehicleService;
  private final ServletState servletState;

  private static final Logger logger = Logger.getLogger(TripMatcher.class.getName());

  @Inject
  public TripMatcher(
      AuthenticatedGrpcServiceProvider grpcServiceProvider, ServletState servletState) {
    this.authenticatedServerTripService = grpcServiceProvider.getAuthenticatedTripService();
    this.authenticatedServerVehicleService = grpcServiceProvider.getAuthenticatedVehicleService();
    this.servletState = servletState;
  }

  /** Determines if the given vehicle is ready to take a match based on current state. */
  public boolean isVehicleReadyForMatch() {
    String vehicleId = servletState.getVehicleId();

    if (servletState.hasTripPendingMatch() == false) {
      return false;
    }

    GetVehicleRequest getVehicleRequest =
        GetVehicleRequest.newBuilder().setName(VehicleUtils.getVehicleName(vehicleId)).build();

    Vehicle vehicle = authenticatedServerVehicleService.getVehicle(getVehicleRequest);

    int numberOfTripsAssigned = vehicle.getCurrentTripsList().size();

    if (numberOfTripsAssigned >= 2) {
      return false;
    }

    if (numberOfTripsAssigned == 0) {
      return true;
    }

    if (vehicle.getBackToBackEnabled() == false) {
      return false;
    }

    Trip currentTrip = servletState.getActiveTripsMap().get(vehicle.getCurrentTripsList().get(0));

    GetTripRequest getTripRequest =
        GetTripRequest.newBuilder().setName(currentTrip.getName()).build();

    Trip trip = authenticatedServerTripService.getTrip(getTripRequest);

    return trip.getTripStatus() != TripStatus.ENROUTE_TO_PICKUP
        && trip.getTripStatus() != TripStatus.ARRIVED_AT_PICKUP
        && trip.getTripStatus() != TripStatus.NEW;
  }

  /** Assigns a trip ready to match to the given vehicle. */
  public synchronized void triggerMatching() {
    String vehicleId = servletState.getVehicleId();

    logger.info(String.format("triggerMatching() vehicleId: %s", vehicleId));

    Trip tripToMatch = servletState.getNextTripToMatch();

    UpdateTripRequest updateRequest =
        UpdateTripRequest.newBuilder()
            .setName(tripToMatch.getName())
            .setTrip(Trip.newBuilder().setVehicleId(vehicleId).build())
            .setUpdateMask(FieldMask.newBuilder().addPaths("vehicle_id").build())
            .build();

    Trip updatedTrip = authenticatedServerTripService.updateTrip(updateRequest);
    servletState.getActiveTripsMap().put(updatedTrip.getName(), updatedTrip);

    logger.info(
        String.format(
            "triggerMatching() completed vehicleId: %s tripName: %s",
            vehicleId, tripToMatch.getName()));
  }
}
