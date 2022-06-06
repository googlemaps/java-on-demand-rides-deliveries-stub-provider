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
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.inject.Inject;
import google.maps.fleetengine.v1.CreateVehicleRequest;
import google.maps.fleetengine.v1.GetVehicleRequest;
import google.maps.fleetengine.v1.TripType;
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
  private static final String BACK_TO_BACK_ENABLED_FIELD = "backToBackEnabled";
  private static final String SUPPORTED_TRIP_TYPES_FIELD = "supportedTripTypes";
  private static final String MAXIMUM_CAPACITY_FIELD = "maximumCapacity";

  private static final int MAXIMUM_CAPACITY_DEFAULT = 4;
  private static final TripType[] SUPPORTED_TRIP_TYPES_DEFAULT =
      new TripType[] {TripType.EXCLUSIVE};

  private final AuthenticatedGrpcServiceProvider grpcServiceProvider;
  private final ServletState servletState;
  private final TripMatcher tripMatcher;

  @Inject
  public VehicleServlet(
      ServletState servletState,
      AuthenticatedGrpcServiceProvider grpcServiceProvider,
      ServletStatePropertyChangeListener propertyChangeListener,
      TripMatcher tripMatcher) {
    super();

    this.servletState = servletState;
    this.grpcServiceProvider = grpcServiceProvider;
    this.tripMatcher = tripMatcher;

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
    servletState.setVehicleId(vehicleId);

    logger.info(String.format("Vehicle:\n%s", vehicle));

    if (vehicle != null) {
      if (tripMatcher.isVehicleReadyForMatch()) {
        tripMatcher.triggerMatching();
        vehicle = vehicleService.getVehicle(getVehicleRequest);
      }
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

    boolean backToBackEnabled =
        jsonBody.has(BACK_TO_BACK_ENABLED_FIELD)
            && jsonBody.get(BACK_TO_BACK_ENABLED_FIELD).getAsBoolean() == true;

    int maximumCapacity =
        jsonBody.has(MAXIMUM_CAPACITY_FIELD)
            ? jsonBody.get(MAXIMUM_CAPACITY_FIELD).getAsInt()
            : MAXIMUM_CAPACITY_DEFAULT;

    TripType[] supportedTripTypes =
        jsonBody.has(SUPPORTED_TRIP_TYPES_FIELD)
            ? new Gson().fromJson(jsonBody.get(SUPPORTED_TRIP_TYPES_FIELD), TripType[].class)
            : SUPPORTED_TRIP_TYPES_DEFAULT;

    Vehicle vehicle =
        VehicleUtils.createVehicle(
            vehicleId,
            backToBackEnabled,
            maximumCapacity,
            ImmutableList.copyOf(supportedTripTypes));

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

    servletState.setVehicleId(vehicleId);
    logger.info(String.format("Vehicle:\n%s", vehicle));

    response.getWriter().print(GsonProvider.get().toJson(createdVehicle));
    response.getWriter().flush();
  }
}
