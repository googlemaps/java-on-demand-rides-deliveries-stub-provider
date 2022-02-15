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
package com.example.provider;

import com.example.provider.auth.grpcservice.AuthenticatedGrpcServiceProvider;
import com.example.provider.json.GsonProvider;
import com.example.provider.utils.ServletUtils;
import com.example.provider.utils.VehicleUtils;
import com.google.common.base.Ascii;
import com.google.common.base.Strings;
import com.google.common.io.CharStreams;
import com.google.gson.JsonObject;
import com.google.inject.Inject;
import google.maps.fleetengine.v1.CreateVehicleRequest;
import google.maps.fleetengine.v1.GetVehicleRequest;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.VehicleServiceClient;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Singleton;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet for vehicle endpoints. */
@Singleton
public class VehicleServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(VehicleServlet.class.getName());

  private static final String SUPPORTED_POST_LINK = "/new";
  private static final String VEHICLE_ID_FIELD = "vehicleId";

  private final AuthenticatedGrpcServiceProvider grpcServiceProvider;

  private final ServletState servletState;

  @Inject
  public VehicleServlet(
      ServletState servletState,
      AuthenticatedGrpcServiceProvider grpcServiceProvider,
      ServletStatePropertyChangeListener propertyChangeListener) {
    super();

    this.servletState = servletState;
    this.grpcServiceProvider = grpcServiceProvider;

    this.servletState.addPropertyChangeListener(propertyChangeListener);
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ServletUtils.setStandardResponseHeaders(response);

    VehicleServiceClient vehicleService = grpcServiceProvider.getAuthenticatedVehicleService();

    // remove preceding "/"
    String vehicleId = request.getPathInfo().substring(1);

    logger.info(String.format("Getting vehicle with vehicleID: %s", vehicleId));

    GetVehicleRequest getVehicleRequest =
        GetVehicleRequest.newBuilder().setName(VehicleUtils.getVehicleName(vehicleId)).build();

    Vehicle vehicle = vehicleService.getVehicle(getVehicleRequest);
    logger.info(String.format("Vehicle:\n%s", vehicle));

    if (vehicle != null) {
      servletState.setLastVehicleId(vehicleId);
    }

    response.getWriter().print(GsonProvider.get().toJson(vehicle));
    response.getWriter().flush();
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ServletUtils.setStandardResponseHeaders(response);
    String pathInfo = Strings.nullToEmpty(request.getPathInfo());
    if (!Ascii.equalsIgnoreCase(pathInfo, SUPPORTED_POST_LINK)) {
      String message = String.format("Unsupported POST endpoint: %s", pathInfo);
      response.sendError(HttpServletResponse.SC_NOT_FOUND, message);
      return;
    }

    VehicleServiceClient vehicleService = grpcServiceProvider.getAuthenticatedVehicleService();

    String postData = CharStreams.toString(request.getReader());
    JsonObject jsonBody = GsonProvider.get().fromJson(postData, JsonObject.class);

    if (!jsonBody.has(VEHICLE_ID_FIELD)) {
      String message = "Vehicle ID was not provided.";
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, message);
      return;
    }

    String vehicleId = jsonBody.get(VEHICLE_ID_FIELD).getAsString();

    logger.info(String.format("Creating vehicle with vehicleID: %s", vehicleId));

    // TODO(b/153661805) Add support to add form body fields for vehicle creation
    Vehicle vehicle = VehicleUtils.createVehicle(vehicleId);
    CreateVehicleRequest createVehicleRequest =
        CreateVehicleRequest.newBuilder()
            .setParent(VehicleUtils.PROVIDER_NAME)
            .setVehicleId(vehicleId)
            .setVehicle(vehicle)
            .build();

    Vehicle createdVehicle;
    try {
      createdVehicle = vehicleService.createVehicle(createVehicleRequest);
    } catch (StatusRuntimeException e) {
      logger.warning(String.format("GRPC reported exception: %s", e.getStatus()));
      if (e.getStatus().getCode().equals(Status.ALREADY_EXISTS.getCode())) {
        response.sendError(
            HttpServletResponse.SC_BAD_REQUEST,
            String.format("Vehicle already exists with the vehicleId: %s", vehicleId));
        return;
      }
      response.sendError(
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
          String.format("Error has occurred with the Grpc service: %s", e));
      return;
    }

    servletState.setLastVehicleId(vehicleId);
    logger.info(String.format("Vehicle:\n%s", vehicle));

    response.getWriter().print(GsonProvider.get().toJson(createdVehicle));
    response.getWriter().flush();
  }
}
