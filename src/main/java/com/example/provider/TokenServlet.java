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

import com.example.provider.json.GsonProvider;
import com.example.provider.utils.ServletUtils;
import com.google.common.base.Ascii;
import com.google.fleetengine.auth.AuthTokenMinter;
import com.google.fleetengine.auth.token.FleetEngineToken;
import com.google.fleetengine.auth.token.FleetEngineTokenType;
import com.google.fleetengine.auth.token.TripClaims;
import com.google.fleetengine.auth.token.VehicleClaims;
import com.google.fleetengine.auth.token.factory.signer.SigningTokenException;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for token endpoints to get signed tokens.
 *
 * <p>GET /token/driver/:vehicleId
 *
 * <p>GET /token/consumer/:tripId
 *
 * <p>GET /token/server
 */
@Singleton
public class TokenServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(TokenServlet.class.getName());
  private final AuthTokenMinter minter;

  @Inject
  TokenServlet(AuthTokenMinter minter) {
    super();
    this.minter = minter;
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ServletUtils.setStandardResponseHeaders(response);

    String pathInfo = request.getPathInfo();
    if (pathInfo == null || pathInfo.length() <= 1) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid token request.");
      return;
    }

    String tokenType = pathInfo.substring(1);
    int separatorIndex = tokenType.indexOf("/");
    String id = null;
    if (separatorIndex != -1) {
      id = tokenType.substring(separatorIndex + 1);
      tokenType = tokenType.substring(0, separatorIndex);
    }

    FleetEngineTokenType tokenTypeEnum;
    try {
      tokenTypeEnum = FleetEngineTokenType.valueOf(Ascii.toUpperCase(tokenType));
    } catch (IllegalArgumentException e) {
      logger.warning(
          String.format("Requested token for tokenType [%s], but did not find token.", tokenType));
      response.sendError(
          HttpServletResponse.SC_BAD_REQUEST,
          String.format("Could not find token for the given type: %s", tokenType));
      return;
    }

    FleetEngineToken authToken;
    try {
      switch (tokenTypeEnum) {
        case DRIVER:
          if (id == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Vehicle ID was not provided.");
            return;
          }
          authToken = this.minter.getDriverToken(VehicleClaims.create(id));
          break;
        case CONSUMER:
          if (id == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Trip ID was not provided.");
            return;
          }
          authToken = this.minter.getConsumerToken(TripClaims.create(id));
          break;
        case SERVER:
          authToken = this.minter.getServerToken();
          break;
        default:
          logger.severe("Requested token for tokenType [%s], but it should not get here.");
          response.sendError(
              HttpServletResponse.SC_BAD_REQUEST,
              String.format("Could not find token for the given type: %s", tokenType));
          return;
      }
    } catch (SigningTokenException exception) {
      throw new SampleProviderException("Error signing token", exception);
    }

    logger.info(String.format("Found token for type %s: %s", tokenType, authToken.jwt()));

    response.getWriter().print(GsonProvider.get().toJson(authToken));
    response.getWriter().flush();
  }
}
