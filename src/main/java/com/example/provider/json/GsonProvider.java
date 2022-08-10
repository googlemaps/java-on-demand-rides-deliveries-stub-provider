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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.type.LatLng;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.VehicleAttribute;
import java.util.Date;

/**
 * Provider for Gson after setting custom serializer and deserializer.
 *
 * <p>Registers the following serializers and deserializers: - VehicleSerializer for serializing
 * fleetengine vehicles - LatLngDeserializer for deserializing LatLng protos
 */
public final class GsonProvider {

  private static Gson gson;

  /**
   * Returns the created Gson if it was already created before. Otherwise, create a new one with
   * serializers and deserializers.
   */
  public static Gson get() {
    if (gson != null) {
      return gson;
    }

    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder
        .registerTypeAdapter(Vehicle.class, new VehicleSerializer())
        .registerTypeAdapter(Trip.class, new TripSerializer())
        .registerTypeAdapter(Date.class, new DateSerializer())
        .registerTypeAdapter(LatLng.class, new LatLngDeserializer())
        .registerTypeAdapter(VehicleAttribute.class, new VehicleAttributeSerializer())
        .registerTypeAdapter(VehicleAttribute.class, new VehicleAttributeDeserializer())
        .setPrettyPrinting();
    gson = gsonBuilder.create();
    return gson;
  }

  private GsonProvider() {}
}
