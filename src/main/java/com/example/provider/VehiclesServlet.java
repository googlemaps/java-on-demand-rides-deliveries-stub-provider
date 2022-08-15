/* Copyright 2022 Google LLC
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
package com.example.provider;

import com.example.provider.auth.grpcservice.AuthenticatedGrpcServiceProvider;
import com.example.provider.json.GsonProvider;
import com.example.provider.utils.ServletUtils;
import com.example.provider.utils.VehicleUtils;
import com.google.inject.Inject;
import google.maps.fleetengine.v1.ListVehiclesRequest;
import google.maps.fleetengine.v1.ListVehiclesRequest.Builder;
import google.maps.fleetengine.v1.VehicleServiceClient;
import google.maps.fleetengine.v1.VehicleServiceClient.ListVehiclesPagedResponse;
import google.maps.fleetengine.v1.VehicleState;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Singleton;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet for vehicles endpoints. */
@Singleton
public class VehiclesServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(VehiclesServlet.class.getName());

  private final VehicleServiceClient vehicleServiceClient;

  private static final String RESTAURANT_ID_FIELD = "restaurantId";

  @Inject
  public VehiclesServlet(AuthenticatedGrpcServiceProvider grpcServiceProvider) {
    super();

    this.vehicleServiceClient = grpcServiceProvider.getAuthenticatedVehicleService();
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ServletUtils.setStandardResponseHeaders(response);

    String restaurantId = ServletUtils.getEntityIdFromRequestPath(request);

    ListVehiclesRequest listVehiclesRequest;
    Builder listVehiclesRequestBuilder =
        ListVehiclesRequest.newBuilder()
            .setParent(VehicleUtils.PROVIDER_NAME)
            .setVehicleState(VehicleState.ONLINE)
            .setPageSize(100);

    if (restaurantId != null && !restaurantId.isEmpty()) {
      String restaurantIdAttribute = RESTAURANT_ID_FIELD + ":" + restaurantId;
      listVehiclesRequestBuilder.addRequiredAttributes(restaurantIdAttribute);
      listVehiclesRequest = listVehiclesRequestBuilder.build();
      logger.info("Getting a list of vehicles with the restaurant ID " + restaurantId);
    } else {
      listVehiclesRequest = listVehiclesRequestBuilder.build();
      logger.info("Getting a list of all vehicles");
    }

    ListVehiclesPagedResponse listVehiclesResponse =
        vehicleServiceClient.listVehicles(listVehiclesRequest);
    response
        .getWriter()
        .print(GsonProvider.get().toJson(listVehiclesResponse.getPage().getValues()));
    response.getWriter().flush();
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {}

  @Override
  public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {}
}
