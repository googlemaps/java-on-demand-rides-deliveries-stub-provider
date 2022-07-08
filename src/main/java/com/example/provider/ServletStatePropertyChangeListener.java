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

    if (propertyName.equals(ServletState.VEHICLE_PROPERTY_KEY)) {
      String vehicleId = event.getNewValue().toString();
      searchAndCancelTrips(vehicleId);

      servletState.clearTrips();
    }
  }

  /**
   * Find trips with corresponding vehicleId to set the status to cancel.
   *
   * <p>The sample provider currently manages a singleton Vehicle.
   */
  private void searchAndCancelTrips(String vehicleId) {
    logger.info(String.format("Searching for trips with vehicleId: %s", vehicleId));
    SearchTripsRequest searchRequest =
        SearchTripsRequest.newBuilder()
            .setParent(TripUtils.PROVIDER_NAME)
            .setVehicleId(vehicleId)
            .setActiveTripsOnly(true)
            .build();

    SearchTripsPagedResponse tripResponse =
        authenticatedServerTripService.searchTrips(searchRequest);
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
