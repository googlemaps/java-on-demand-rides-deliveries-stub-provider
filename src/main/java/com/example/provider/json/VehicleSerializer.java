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

import static java.util.stream.Collectors.toList;

import com.example.provider.utils.WaypointUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import google.maps.fleetengine.v1.Vehicle;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Serializer for vehicle object to provide relevant information to its clients.
 *
 * <p>From the fleetengine vehicle object, this serializer retrieves the name and the vehicleState.
 */
final class VehicleSerializer implements JsonSerializer<Vehicle> {

  @Override
  public JsonElement serialize(Vehicle src, Type typeOfSrc, JsonSerializationContext context) {
    List<Waypoint> waypoints =
        src.getWaypointsList()
            .stream()
            .map(
                waypoint ->
                    Waypoint.newBuilder()
                        .setTripId(waypoint.getTripId())
                        .setWaypointType(
                            WaypointUtils.getWaypointTypeString(waypoint.getWaypointType()))
                        .setLocation(
                            SerializationUtils.createSerializedLocation(
                                waypoint.getLocation().getPoint()))
                        .build())
            .collect(toList());
    SerializedLocation serializedLastLocation = null;
    if (src.getLastLocation() != null) {
      SerializedLatLng serializedLatLng =
          SerializedLatLng.newBuilder()
              .setLatitude(src.getLastLocation().getLocation().getLatitude())
              .setLongitude(src.getLastLocation().getLocation().getLongitude())
              .build();

      int vehicleHeading =
          src.getLastLocation().hasHeading() ? src.getLastLocation().getHeading().getValue() : 0;
      serializedLastLocation =
          SerializedLocation.newBuilder()
              .setPoint(serializedLatLng)
              .setHeading(vehicleHeading)
              .build();
    }

    SerializedVehicle vehicle =
        SerializedVehicle.newBuilder()
            .setName(src.getName())
            .setVehicleState(src.getVehicleState().name())
            .setCurrentTripsIds(src.getCurrentTripsList())
            .setWaypoints(waypoints)
            .setBackToBackEnabled(src.getBackToBackEnabled())
            .setSupportedTripTypes(src.getSupportedTripTypesList())
            .setMaximumCapacity(src.getMaximumCapacity())
            .setLastLocation(serializedLastLocation)
            .setVehicleAttributes(src.getAttributesList())
            .setVehicleType(src.getVehicleType())
            .setEtaToFirstWaypoint(src.getEtaToFirstWaypoint())
            .build();

    return new Gson().toJsonTree(vehicle);
  }
}
