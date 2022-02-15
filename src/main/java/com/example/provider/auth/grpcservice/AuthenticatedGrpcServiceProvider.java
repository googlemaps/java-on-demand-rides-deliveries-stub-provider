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

import google.maps.fleetengine.v1.TripServiceClient;
import google.maps.fleetengine.v1.VehicleServiceClient;

/** Provider to get authenticated Grpc services. */
public interface AuthenticatedGrpcServiceProvider {

  /** Gets the authenticated version of VehicleService for Grpc call. */
  VehicleServiceClient getAuthenticatedVehicleService();

  /** Gets the authenticated trip service used for Grpc calls. */
  TripServiceClient getAuthenticatedTripService();
}
