/* Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.provider.json;

import com.google.auto.value.AutoValue;
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
  /** List of assigned trip Ids for vehicle */
  abstract List<String> currentTripsIds();

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
     * @param vehicleState current state of vehicle in fleetengine.
     */
    abstract Builder setVehicleState(String vehicleState);

    /**
     * Setter for list of IDs of trips assigned to vehicle.
     *
     * @param vehicleState current list of trip ids in Fleet Engine.
     */
    abstract Builder setCurrentTripsIds(List<String> currentTripsIds);

    abstract SerializedVehicle build();
  }
}
