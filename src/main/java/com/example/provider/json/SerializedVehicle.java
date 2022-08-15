/* Copyright 2020 Google LLC
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
package com.example.provider.json;

import com.google.auto.value.AutoValue;
import com.google.protobuf.Timestamp;
import google.maps.fleetengine.v1.TripType;
import google.maps.fleetengine.v1.Vehicle.VehicleType;
import google.maps.fleetengine.v1.VehicleAttribute;
import java.util.List;

/**
 * Vehicle object to serialize to clients. This object will only contain relevant vehicle
 * information to send to the clients.
 */
@AutoValue
abstract class SerializedVehicle {

  /** Name of the vehicle. */
  abstract String name();
  /** Current state of the vehicle given by fleetengine. */
  abstract String vehicleState();
  /** List of remanining waypoints. Ex: Waypoints that the vehicle will visit next. */
  abstract List<Waypoint> waypoints();
  /** List of assigned trip Ids for vehicle */
  abstract List<String> currentTripsIds();
  /** Back to back enabled */
  abstract boolean backToBackEnabled();
  /** Maximum capacity */
  abstract int maximumCapacity();
  /** Supported trip types */
  abstract List<TripType> supportedTripTypes();
  /** Last location of vehicle */
  abstract SerializedLocation lastLocation();
  /** Vehicle attributes */
  abstract List<VehicleAttribute> vehicleAttributes();
  /** Vehicle type */
  abstract VehicleType vehicleType();
  /** ETA to first waypoint */
  abstract Timestamp etaToFirstWaypoint();

  static Builder newBuilder() {
    return new AutoValue_SerializedVehicle.Builder();
  }

  /** Builder for this serialized vehicle. */
  @AutoValue.Builder
  abstract static class Builder {

    /**
     * Setter for name.
     *
     * @param name name of the vehicle.
     */
    abstract Builder setName(String name);

    /**
     * Setter for vehicle state.
     *
     * @param vehicleState current state of vehicle in Fleet Engine.
     */
    abstract Builder setVehicleState(String vehicleState);

    /**
     * Setter for list of IDs of trips assigned to vehicle.
     *
     * @param currentTripsIds current list of trip ids in Fleet Engine.
     */
    abstract Builder setCurrentTripsIds(List<String> currentTripsIds);

    /**
     * Setter for the remaining waypoints for the vehicle.
     *
     * @param waypoints list of remaining waypoints.
     */
    abstract Builder setWaypoints(List<Waypoint> waypoints);

    /**
     * Setter for the backToBackEnabled setting for the vehicle.
     *
     * @param backToBackEnabled indicates if vehicle supports B2B trips.
     */
    abstract Builder setBackToBackEnabled(boolean backToBackEnabled);

    /**
     * Setter for the maximum passenger capacity.
     *
     * @param maximumCapacity vehicle maximum passengers capacity.
     */
    abstract Builder setMaximumCapacity(int maximumCapacity);

    /**
     * Setter for the list of supported trip types for the vehicle.
     *
     * @param supportedTripTypes list of supported trip types.
     */
    abstract Builder setSupportedTripTypes(List<TripType> supportedTripTypes);

    /**
     * Setter for the last reported location of the vehicle.
     *
     * @param lastLocation last reported location of the vehicle.
     */
    abstract Builder setLastLocation(SerializedLocation lastLocation);

    /**
     * Setter for the list of vehicle attributes.
     *
     * @param vehicleAttributes attribute list of vehicle.
     */
    abstract Builder setVehicleAttributes(List<VehicleAttribute> vehicleAttributes);

    /**
     * Setter for the type category of the vehicle.
     *
     * @param vehicleType type category of the vehicle.
     */
    abstract Builder setVehicleType(VehicleType vehicleType);

    /**
     * Setter for the ETA to the first waypoint of the vehicle.
     *
     * @param etaToFirstWaypoint time needed to get to the first waypoint of the vehicle.
     */
    abstract Builder setEtaToFirstWaypoint(Timestamp etaToFirstWaypoint);

    abstract SerializedVehicle build();
  }
}
