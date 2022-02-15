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
package com.example.provider.auth.grpcservice;

import com.example.provider.utils.SampleProviderUtils;
import com.google.fleetengine.auth.AuthTokenMinter;
import com.google.fleetengine.auth.client.FleetEngineClientSettingsModifier;
import com.google.inject.Inject;
import google.maps.fleetengine.v1.TripServiceClient;
import google.maps.fleetengine.v1.TripServiceSettings;
import google.maps.fleetengine.v1.VehicleServiceClient;
import google.maps.fleetengine.v1.VehicleServiceSettings;
import java.io.IOException;

final class AuthenticatedGrpcServiceProviderImpl implements AuthenticatedGrpcServiceProvider {

  private static final String API_KEY_PROP = "x-goog-api-key";
  private static final String FIELDMASK_PROP = "x-goog-fieldmask";
  private static final String FIELDMASK_VALUE =
      "routes.route.distanceMeters,routes.route.duration,routes.token,"
          + "fastest_route.route.duration,fastest_route.token,"
          + "shortest_route.route.distanceMeters,shortest_route.token";

  private final VehicleServiceClient vehicleService;

  private final TripServiceClient tripService;

  @Inject
  AuthenticatedGrpcServiceProviderImpl(AuthTokenMinter minter) throws IOException {

    TripServiceSettings tripSettings =
        new FleetEngineClientSettingsModifier<TripServiceSettings, TripServiceSettings.Builder>(
                minter)
            .updateBuilder(TripServiceSettings.newBuilder())
            .setEndpoint(SampleProviderUtils.providerProperties.fleetEngineAddress())
            .build();
    tripService = TripServiceClient.create(tripSettings);

    VehicleServiceSettings vehicleSettings =
        new FleetEngineClientSettingsModifier<
                VehicleServiceSettings, VehicleServiceSettings.Builder>(minter)
            .updateBuilder(VehicleServiceSettings.newBuilder())
            .setEndpoint(SampleProviderUtils.providerProperties.fleetEngineAddress())
            .build();
    vehicleService = VehicleServiceClient.create(vehicleSettings);
  }

  @Override
  public VehicleServiceClient getAuthenticatedVehicleService() {
    return vehicleService;
  }

  @Override
  public TripServiceClient getAuthenticatedTripService() {
    return tripService;
  }
}
