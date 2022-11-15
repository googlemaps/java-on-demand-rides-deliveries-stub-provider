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

import google.maps.fleetengine.v1.Trip;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.inject.Singleton;

/**
 * Shared state among the servlets.
 *
 * <p>Stores the created vehicleId and trip that will be used in the matching process. The reason
 * for this singleton state is that this app will be used for journey sharing supporting only one
 * exclusive ride so the provider will only be working with one single vehicle. There's also an
 * assumption that only one pair of driver/consumer app will be in use. This is just to demonstrate
 * the journey sharing process and should not be a reference of how a production environment is to
 * be expected.
 *
 * <p>Provides vehicleId updates to registered {@code PropertyChangeListener} objects.
 */
@Singleton
class ServletState {
  /** Key used to identify the vehicleid property in PropertyChangeEvent signals. */
  public static final String VEHICLE_PROPERTY_KEY = "vehicleid";

  private static final Logger logger = Logger.getLogger(ServletState.class.getName());

  private String vehicleId;

  /** Queue of trips created awaiting to be matched. */
  private List<Trip> tripsPendingMatches = new LinkedList<>();

  /** List of current active trips. */
  private Map<String, Trip> tripsMap = new HashMap<>();

  private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  public synchronized void clearTrips() {
    tripsPendingMatches.clear();
    tripsMap.clear();
  }

  /**
   * Sets the current active vehicleId. It also triggers a 'property change' event which ends up
   * cancelling the trips assigned to the previous vehicle.
   */
  public synchronized void setVehicleId(String vehicleId) {
    if (this.vehicleId != null && !this.vehicleId.equals(vehicleId)) {
      propertyChangeSupport.firePropertyChange(VEHICLE_PROPERTY_KEY, this.vehicleId, vehicleId);
    }

    this.vehicleId = vehicleId;
  }

  /** Adds a trip to the queue of trips to match as well as to the map of active trips. */
  public synchronized void addTrip(String tripId, Trip trip) {
    logger.info(String.format("addTrip: %s", tripId));

    tripsMap.put(tripId, trip);
    tripsPendingMatches.add(trip);
  }

  /**
   * Removes a trip from the list of active trips. (Ex: when status is CANCELED/COMPLETED/UNKNOWN)
   */
  public synchronized void removeTrip(String tripId) {
    tripsMap.remove(tripId);
  }

  /** Gets the trip given by ID from the map of active trips. */
  public synchronized Trip getTrip(String tripId) {
    return tripsMap.get(tripId);
  }

  /** Returns the current vehicleId. */
  public synchronized String getVehicleId() {
    return vehicleId;
  }

  /** Checks if there are any active trips. */
  public synchronized boolean hasNoTrips() {
    return tripsMap.isEmpty();
  }

  /** Gets the list of pending matches. */
  public synchronized List<Trip> getTripsPendingMatches() {
    return tripsPendingMatches;
  }

  /** Removes the given trip from the queue of pending matches. */
  public synchronized void removeTripPendingMatch(Trip trip) {
    tripsPendingMatches.remove(trip);
  }

  public synchronized Map<String, Trip> getActiveTripsMap() {
    return tripsMap;
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }
}
