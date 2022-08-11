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
import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * Trip object to serialize to clients. This object will only contain relevant trip information to
 * send to the clients.
 */
@AutoValue
abstract class SerializedTrip {

  /** Name of the trip. */
  abstract String name();
  /** Current status of the trip. */
  abstract String tripStatus();
  /** Locations the vehicle should move to. */
  abstract ImmutableList<Waypoint> waypoints();
  /** ID of the vehicle. */
  abstract String vehicleId();
  /** Route for this trip. */
  abstract List<SerializedLatLng> routeList();

  static Builder newBuilder() {
    return new AutoValue_SerializedTrip.Builder();
  }

  /** Builder for this serialized trip. */
  @AutoValue.Builder
  abstract static class Builder {

    abstract Builder setName(String name);

    abstract Builder setRouteList(List<SerializedLatLng> serializedRouteList);

    abstract Builder setTripStatus(String tripStatus);

    abstract Builder setWaypoints(List<Waypoint> waypoints);

    abstract Builder setVehicleId(String vehicleId);

    abstract SerializedTrip build();
  }
}
