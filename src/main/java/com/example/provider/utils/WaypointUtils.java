/*
 * Copyright 2022 Google LLC
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
package com.example.provider.utils;

import com.example.provider.json.Waypoint.WaypointType;

/** Utility class for waypoint related logic. */
public final class WaypointUtils {
  /** Returns a Provider 'WaypointType' value based on the provided FleetEngine enum value. */
  public static WaypointType getWaypointTypeString(
      google.maps.fleetengine.v1.WaypointType waypointType) {
    switch (waypointType) {
      case PICKUP_WAYPOINT_TYPE:
        return WaypointType.PICKUP_WAYPOINT_TYPE;

      case DROP_OFF_WAYPOINT_TYPE:
        return WaypointType.DROP_OFF_WAYPOINT_TYPE;

      case INTERMEDIATE_DESTINATION_WAYPOINT_TYPE:
        return WaypointType.INTERMEDIATE_DESTINATION_WAYPOINT_TYPE;

      default:
        throw new IllegalArgumentException("Invalid waypoint type");
    }
  }
}
