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

import static com.google.common.base.Preconditions.checkNotNull;

import com.example.provider.auth.grpcservice.AuthenticatedGrpcServiceProvider;
import com.example.provider.utils.TripUtils;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.protobuf.FieldMask;
import google.maps.fleetengine.v1.SearchTripsRequest;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.TripServiceClient;
import google.maps.fleetengine.v1.TripServiceClient.SearchTripsPagedResponse;
import google.maps.fleetengine.v1.TripStatus;
import google.maps.fleetengine.v1.UpdateTripRequest;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.logging.Logger;

/** PropertyChangeListener class for ServletState. */
class ServletStatePropertyChangeListener implements PropertyChangeListener {

  private static final Logger logger =
      Logger.getLogger(ServletStatePropertyChangeListener.class.getName());

  private static final String TRIP_VEHICLE_ID_PROPERTY = "vehicle_id";
  private static final String TRIP_STATUS_PROPERTY = "trip_status";

  private final TripServiceClient authenticatedServerTripService;
  private final ServletState servletState;

  @Inject
  public ServletStatePropertyChangeListener(
      ServletState servletState, AuthenticatedGrpcServiceProvider grpcServiceProvider) {
    this.servletState = servletState;
    this.authenticatedServerTripService = grpcServiceProvider.getAuthenticatedTripService();
  }

  /**
   * Handles {@code ServletState.VEHICLE_PROPERTY_KEY} property changes by matching the new
   * vehicleid with an existing trip.
   *
   * @throws NullPointerException if {@code event} or {@code servletState} is null.
   */
  @Override
  public void propertyChange(PropertyChangeEvent event) {
    checkNotNull(event);
    checkNotNull(servletState);

    String propertyName = Strings.nullToEmpty(event.getPropertyName());
    if (propertyName.equals(ServletState.VEHICLE_PROPERTY_KEY)
        && servletState.getLastTrip() != null) {
      String vehicleId = event.getNewValue().toString();
      searchAndCancelTrip(vehicleId, servletState.getLastTrip());

      logger.info(String.format("Matching trip with vehicle id:\n%s", vehicleId));

      // Match previously created trip to vehicle.
      UpdateTripRequest updateReq =
          UpdateTripRequest.newBuilder()
              .setName(servletState.getLastTrip().getName())
              .setTrip(Trip.newBuilder().setVehicleId(vehicleId).build())
              .setUpdateMask(FieldMask.newBuilder().addPaths(TRIP_VEHICLE_ID_PROPERTY).build())
              .build();

      Trip updatedTrip = authenticatedServerTripService.updateTrip(updateReq);
      servletState.setLastTrip(updatedTrip);

      logger.info(String.format("Trip:\n%s", updatedTrip));
    } else if (propertyName.equals(ServletState.TRIP_PROPERTY_KEY)) {
      String vehicleId = Strings.nullToEmpty(servletState.getLastVehicleId());
      if (vehicleId.isEmpty()) {
        return;
      }

      Trip createdTrip = (Trip) event.getNewValue();
      searchAndCancelTrip(vehicleId, createdTrip);
    }
  }

  /**
   * Find trips with corresponding vehicleId to set the status to cancel.
   *
   * <p>This is because this provider is a naive provider that matches the last saved trip with the
   * last vehicle ID, but there is an issue creating another trip matched to the same vehicle and
   * journeysharing will not start for the new trip. Find trips matched to the vehicle and set the
   * status to cancelled.
   */
  private void searchAndCancelTrip(String vehicleId, Trip lastCreatedTrip) {
    logger.info(String.format("Searching for trips with vehicleId: %s", vehicleId));
    SearchTripsRequest searchReq =
        SearchTripsRequest.newBuilder()
            .setParent(TripUtils.PROVIDER_NAME)
            .setVehicleId(vehicleId)
            .setActiveTripsOnly(true)
            .build();

    SearchTripsPagedResponse tripResponse = authenticatedServerTripService.searchTrips(searchReq);
    if (tripResponse.getPage() == null) {
      logger.info(String.format("No trips found with vehicleId: %s", vehicleId));
      return;
    }

    Iterator<Trip> trips = tripResponse.iterateAll().iterator();
    if (!trips.hasNext()) {
      logger.info(String.format("No trips found with vehicleId: %s", vehicleId));
      return;
    }

    while (trips.hasNext()) {
      Trip trip = trips.next();
      String tripName = trip.getName();
      if (lastCreatedTrip == null || !lastCreatedTrip.getName().equals(tripName)) {
        logger.info(String.format("Cancelling Trip: %s", tripName));
        UpdateTripRequest updateReq =
            UpdateTripRequest.newBuilder()
                .setName(tripName)
                .setTrip(Trip.newBuilder().setTripStatus(TripStatus.CANCELED))
                .setUpdateMask(FieldMask.newBuilder().addPaths(TRIP_STATUS_PROPERTY).build())
                .build();

        authenticatedServerTripService.updateTrip(updateReq);
      }
    }
  }
}
