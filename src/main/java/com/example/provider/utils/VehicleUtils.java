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
package com.example.provider.utils;

import com.google.common.collect.ImmutableList;
import com.google.type.LatLng;
import google.maps.fleetengine.v1.TripType;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.Vehicle.VehicleType;
import google.maps.fleetengine.v1.Vehicle.VehicleType.Category;
import google.maps.fleetengine.v1.VehicleAttribute;
import google.maps.fleetengine.v1.VehicleLocation;
import google.maps.fleetengine.v1.VehicleState;

/** Utility class to create Vehicles */
public final class VehicleUtils {

  public static final String PROVIDER_NAME =
      String.format("providers/%s", SampleProviderUtils.providerProperties.providerId());
  public static final String VEHICLE_NAME_FORMAT = PROVIDER_NAME + "/vehicles/%s";

  /** Default latitude for vehicle creation located to Google MTV. */
  private static final double DEFAULT_LATITUDE = 37.419645;
  /** Default longitude for vehicle creation located to Google MTV. */
  private static final double DEFAULT_LONGITUDE = -122.073884;

  private static final int DEFAULT_SPEED = 30;
  private static final double SPEED_ACCURACY = 1.0;

  private VehicleUtils() {}

  /** Get the fleetengine formatted vehicle name given vehicle ID. */
  public static String getVehicleName(String vehicleId) {
    return String.format(VEHICLE_NAME_FORMAT, vehicleId);
  }

  /**
   * Create vehicle using the vehicleId with default parameters. This defaults to creating a 4
   * person vehicle with a default location and default speed.
   *
   * <p>TODO(b/153661805) Adding support for custom parameters.
   */
  public static final Vehicle createVehicle(
      String vehicleId,
      Boolean backToBackEnabled,
      int maximumCapacity,
      ImmutableList<TripType> supportedTripTypes,
      ImmutableList<VehicleAttribute> vehicleAttributes) {
    return Vehicle.newBuilder()
        .setName(getVehicleName(vehicleId))
        .setVehicleState(VehicleState.ONLINE)
        .setMaximumCapacity(maximumCapacity)
        .setVehicleType(VehicleType.newBuilder().setCategory(Category.AUTO))
        .addAllSupportedTripTypes(supportedTripTypes)
        .setLastLocation(getVehicleLocation())
        .setBackToBackEnabled(backToBackEnabled)
        .addAllAttributes(vehicleAttributes)
        .build();
  }

  /**
   * Creates a default location with the current timestamp. The default location is set to Google
   * Mountain View with a default speed of 30mph. This will be customizable in the future.
   */
  private static final VehicleLocation getVehicleLocation() {
    LatLng latlng = ProtosUtil.getLatLng(DEFAULT_LATITUDE, DEFAULT_LONGITUDE);

    return VehicleLocation.newBuilder()
        .setLocation(latlng)
        .setHeading(ProtosUtil.getIntValue(0))
        .setSpeedKmph(ProtosUtil.getIntValue(DEFAULT_SPEED))
        .setAltitude(ProtosUtil.getDoubleValue(0))
        .setSpeedAccuracy(ProtosUtil.getDoubleValue(SPEED_ACCURACY))
        .build();
  }
}
