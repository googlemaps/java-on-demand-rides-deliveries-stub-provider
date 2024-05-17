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
package com.example.provider.utils;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.example.provider.json.ErrorResponse;
import com.example.provider.json.GsonProvider;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/** Util class for common functions for servlets. */
public final class ServletUtils {
  private ServletUtils() {}

  /** Sets response headers with common contents in all responses */
  public static void setStandardResponseHeaders(HttpServletResponse response) {
    response.setContentType(MediaType.APPLICATION_JSON);
    response.setCharacterEncoding(UTF_8.name());
    response.addHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Max-Age", "3600");
  }

  /**
   * Writes an error to the given response with the given message and status.
   *
   * @throws IOException if an error occurs when writing to response.
   */
  public static void setErrorResponse(HttpServletResponse response, String message, int status)
      throws IOException {
    ErrorResponse errorResponse = ErrorResponse.create(message, status);
    response.setStatus(status);
    response.getWriter().write(GsonProvider.get().toJson(errorResponse));
  }

  /**
   * Extracts the 'ID' piece of a URL request. Use for REST endpoints where ID is supplied in that
   * format.
   */
  public static String getEntityIdFromRequestPath(HttpServletRequest request) {
    if (isNullOrEmpty(request.getPathInfo())) {
      return "";
    }
    return request.getPathInfo().substring(1);
  }
}
