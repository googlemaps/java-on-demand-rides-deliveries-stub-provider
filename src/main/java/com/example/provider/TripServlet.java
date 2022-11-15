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

import static com.google.common.base.Strings.isNullOrEmpty;

import com.example.provider.auth.grpcservice.AuthenticatedGrpcServiceProvider;
import com.example.provider.json.GsonProvider;
import com.example.provider.json.TripData;
import com.example.provider.utils.SampleProviderUtils;
import com.example.provider.utils.ServletUtils;
import com.example.provider.utils.TripUtils;
import com.google.common.base.Ascii;
import com.google.common.base.Strings;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.inject.Inject;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import google.maps.fleetengine.v1.CreateTripRequest;
import google.maps.fleetengine.v1.GetTripRequest;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.TripServiceClient;
import google.maps.fleetengine.v1.TripStatus;
import google.maps.fleetengine.v1.TripType;
import google.maps.fleetengine.v1.UpdateTripRequest;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Singleton;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for trip endpoints.
 *
 * <p>GET /trip
 *
 * <p>GET /trip/:tripID
 *
 * <p>POST /trip/new pickup={"latitude":{@code double},"longitude":{@code double}},
 * dropoff={"latitude":{@code double},"longitude":{@code double}},
 * intermediateDestinations={"latitude":{@code double},"longitude":{@code double}}[] (Optional)
 *
 * <p>PUT /trip/:tripID status:{@code TripStatus} intermediateDestinationIndex: {@code int}
 * (Optional)
 */
@Singleton
public final class TripServlet extends HttpServlet {

  private final AuthenticatedGrpcServiceProvider grpcServiceProvider;
  private final ServletState servletState;

  private static final String SUPPORTED_POST_LINK = "/new";

  private static final Logger logger = Logger.getLogger(TripServlet.class.getName());

  private static final String STATUS_INPUT_FIELD = "status";
  private static final String PICKUP_INPUT_FIELD = "pickup";
  private static final String DROPOFF_INPUT_FIELD = "dropoff";
  private static final String TRIP_TYPE_INPUT_FIELD = "tripType";
  private static final String INTERMEDIATE_DESTINATIONS_INPUT_FIELD = "intermediateDestinations";
  private static final String INTERMEDIATE_DESTINATION_INDEX_INPUT_FIELD =
      "intermediateDestinationIndex";
  private static final String TRIP_STATUS_UPDATE_MASK = "trip_status";
  private static final String INTERMEDIATE_DESTINATION_INDEX_UPDATE_MASK =
      "intermediate_destination_index";

  private static final String NOT_PROVIDED_MESSAGE = "%s not provided";

  @Inject
  public TripServlet(
      ServletState servletState, AuthenticatedGrpcServiceProvider grpcServiceProvider) {
    this.servletState = servletState;
    this.grpcServiceProvider = grpcServiceProvider;
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ServletUtils.setStandardResponseHeaders(response);
    if (isNullOrEmpty(request.getPathInfo()) || request.getPathInfo().equals("/")) {
      sendError(response, "Missing trip id in URL.", HttpServletResponse.SC_BAD_REQUEST);
    }

    String tripId = request.getPathInfo().substring(1);

    GetTripRequest getTripRequest =
        GetTripRequest.newBuilder().setName(TripUtils.getTripNameFromId(tripId)).build();

    TripServiceClient authenticatedServerTripService =
        grpcServiceProvider.getAuthenticatedTripService();

    Trip trip = authenticatedServerTripService.getTrip(getTripRequest);

    response.getWriter().print(GsonProvider.get().toJson(TripData.create(trip)));

    logger.info(response.toString());
    response.getWriter().flush();
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ServletUtils.setStandardResponseHeaders(response);
    String pathInfo = Strings.nullToEmpty(request.getPathInfo());

    // Validate endpoint.
    if (!Ascii.equalsIgnoreCase(pathInfo, SUPPORTED_POST_LINK)) {
      String errorMsg = String.format("Unsupported POST endpoint: %s", pathInfo);
      sendError(response, errorMsg, HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    String postData = CharStreams.toString(request.getReader());

    JsonObject jsonBody = GsonProvider.get().fromJson(postData, JsonObject.class);

    // Validate request body.
    if (!jsonBody.has(PICKUP_INPUT_FIELD)) {
      String errorMsg = String.format(NOT_PROVIDED_MESSAGE, PICKUP_INPUT_FIELD);
      sendError(response, errorMsg, HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    if (!jsonBody.has(DROPOFF_INPUT_FIELD)) {
      String errorMsg = String.format(NOT_PROVIDED_MESSAGE, DROPOFF_INPUT_FIELD);
      sendError(response, errorMsg, HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    // Process request.
    JsonElement pickupElement = jsonBody.get(PICKUP_INPUT_FIELD);
    JsonElement dropoffElement = jsonBody.get(DROPOFF_INPUT_FIELD);
    JsonElement intermediateDestinationsElement =
        jsonBody.get(INTERMEDIATE_DESTINATIONS_INPUT_FIELD);
    JsonElement tripTypeElement = jsonBody.get(TRIP_TYPE_INPUT_FIELD);

    Gson gson = GsonProvider.get();

    LatLng pickupLatLng;
    LatLng dropoffLatLng;
    LatLng[] intermediateDestinationsLatLng = null;
    TripType tripType = TripType.EXCLUSIVE;

    try {
      pickupLatLng = gson.fromJson(pickupElement, LatLng.class);
      dropoffLatLng = gson.fromJson(dropoffElement, LatLng.class);

      if (intermediateDestinationsElement != null) {
        intermediateDestinationsLatLng =
            gson.fromJson(intermediateDestinationsElement, LatLng[].class);
      }

      if (tripTypeElement != null) {
        tripType = new Gson().fromJson(tripTypeElement, TripType.class);
      }
    } catch (JsonParseException exception) {
      sendError(response, exception.getMessage(), HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    String tripId = UUID.randomUUID().toString();

    // Do not match automatically for simplicity. This will occur when vehicle state is polled.
    String vehicleId = "";

    Trip trip =
        TripUtils.createTrip(
            tripId,
            vehicleId,
            pickupLatLng,
            dropoffLatLng,
            intermediateDestinationsLatLng,
            tripType);

    CreateTripRequest createReq =
        CreateTripRequest.newBuilder()
            .setParent("providers/" + SampleProviderUtils.providerProperties.providerId())
            .setTripId(tripId)
            .setTrip(trip)
            .build();

    TripServiceClient authenticatedServerTripService =
        grpcServiceProvider.getAuthenticatedTripService();

    Trip createdTrip = authenticatedServerTripService.createTrip(createReq);
    servletState.addTrip(tripId, createdTrip);

    logger.info(String.format("Trip:\n%s", createdTrip));
    response.getWriter().print(gson.toJson(createdTrip));
    response.getWriter().flush();
  }

  @Override
  public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ServletUtils.setStandardResponseHeaders(response);

    if (isNullOrEmpty(request.getPathInfo())) {
      sendError(response, "No Trip ID provided.", HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    String tripId = request.getPathInfo().substring(1);

    String putData = CharStreams.toString(request.getReader());
    JsonObject jsonBody = GsonProvider.get().fromJson(putData, JsonObject.class);

    logger.info(String.format("Updating trip %s with input %s.", tripId, putData));

    UpdateTripRequest updateRequest = getUpdateTripRequest(jsonBody, tripId, response);

    if (updateRequest == null) {
      return;
    }

    TripServiceClient authenticatedServerTripService =
        grpcServiceProvider.getAuthenticatedTripService();

    Trip updatedTrip = authenticatedServerTripService.updateTrip(updateRequest);

    TripStatus updatedTripStatus = updatedTrip.getTripStatus();

    if (updatedTripStatus == TripStatus.COMPLETE || updatedTripStatus == TripStatus.CANCELED) {
      logger.info(
          String.format("Trip %s reached a terminal status. Cleaning up servlet state.", tripId));
      servletState.removeTrip(tripId);
    }

    logger.info(String.format("Trip:\n%s", updatedTrip));
    response.getWriter().print(GsonProvider.get().toJson(updatedTrip));
    response.getWriter().flush();
  }

  private UpdateTripRequest getUpdateTripRequest(
      JsonObject jsonBody, String tripId, HttpServletResponse response) throws IOException {
    if (!jsonBody.has(STATUS_INPUT_FIELD)) {
      sendError(response, "No status provided.", HttpServletResponse.SC_BAD_REQUEST);
      return null;
    }

    String status = jsonBody.get(STATUS_INPUT_FIELD).getAsString();

    TripStatus tripStatus;

    try {
      tripStatus = TripStatus.valueOf(Ascii.toUpperCase(status));
    } catch (IllegalArgumentException e) {
      sendError(response, "Unknown status provided", HttpServletResponse.SC_BAD_REQUEST);
      return null;
    }

    Trip.Builder updatedTripBuilder = Trip.newBuilder().setTripStatus(tripStatus);

    FieldMask.Builder updateTripMaskBuilder =
        FieldMask.newBuilder().addPaths(TRIP_STATUS_UPDATE_MASK);

    if (jsonBody.has(INTERMEDIATE_DESTINATION_INDEX_INPUT_FIELD)) {
      int intermediateDestinationIndex;

      try {
        intermediateDestinationIndex =
            jsonBody.get(INTERMEDIATE_DESTINATION_INDEX_INPUT_FIELD).getAsInt();
      } catch (ClassCastException | IllegalArgumentException e) {
        sendError(
            response,
            "Invalid intermediateDestinationIndex provided.",
            HttpServletResponse.SC_BAD_REQUEST);
        return null;
      }

      Timestamp intermediateDestinationsVersion =
          servletState.getTrip(tripId).getIntermediateDestinationsVersion();

      updatedTripBuilder
          .setIntermediateDestinationsVersion(intermediateDestinationsVersion)
          .setIntermediateDestinationIndex(intermediateDestinationIndex);

      updateTripMaskBuilder.addPaths(INTERMEDIATE_DESTINATION_INDEX_UPDATE_MASK);
    }

    return UpdateTripRequest.newBuilder()
        .setName(TripUtils.getTripNameFromId(tripId))
        .setTrip(updatedTripBuilder.build())
        .setUpdateMask(updateTripMaskBuilder.build())
        .build();
  }

  /**
   * Sends an error response using the specified {@code errorMsg} and {@code errorCode}. Logs {@code
   * errorMsg} as a warning.
   *
   * @throws IOException if write to response fails.
   */
  private static void sendError(HttpServletResponse response, String errorMsg, int errorCode)
      throws IOException {
    logger.log(Level.WARNING, errorMsg);
    ServletUtils.setErrorResponse(response, errorMsg, errorCode);
  }
}
