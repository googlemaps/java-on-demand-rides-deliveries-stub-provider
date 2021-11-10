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

  /** Key used to identify the trip property in PropertyChangeEvent signals. */
  public static final String TRIP_PROPERTY_KEY = "trip";

  private String lastVehicleId;
  private Trip lastTrip;
  private String routeToken;

  private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  public synchronized void setLastVehicleId(String lastVehicleId) {
    propertyChangeSupport.firePropertyChange(
        VEHICLE_PROPERTY_KEY, this.lastVehicleId, lastVehicleId);
    this.lastVehicleId = lastVehicleId;
  }

  public synchronized String getLastVehicleId() {
    return this.lastVehicleId;
  }

  public synchronized void setLastTrip(Trip lastTrip) {
    propertyChangeSupport.firePropertyChange(TRIP_PROPERTY_KEY, this.lastTrip, lastTrip);
    this.lastTrip = lastTrip;
  }

  public synchronized Trip getLastTrip() {
    return this.lastTrip;
  }

  public synchronized void setRouteToken(String routeToken) {
    this.routeToken = routeToken;
  }

  public synchronized String getRouteToken() {
    return this.routeToken;
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    this.propertyChangeSupport.addPropertyChangeListener(listener);
  }
}
