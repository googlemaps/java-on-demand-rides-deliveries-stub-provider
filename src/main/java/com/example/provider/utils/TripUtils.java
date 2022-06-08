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

import static java.util.Arrays.stream;

import com.google.type.LatLng;
import google.maps.fleetengine.v1.TerminalLocation;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.TripType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/** Utility class for Trip. */
public final class TripUtils {

  public static final String PROVIDER_NAME =
      String.format("providers/%s", SampleProviderUtils.providerProperties.providerId());
  public static final String TRIP_NAME_FORMAT =
      "providers/" + SampleProviderUtils.providerProperties.providerId() + "/trips/%s";
  private static final Pattern TRIP_NAME_PATTERN =
      Pattern.compile("/?providers/([\\S]+)/trips/([\\S]+)");
  private static final int DEFAULT_NUM_PASSENGERS = 1;

  private TripUtils() {}

  /** Returns Fleet Engine formatted trip name from trip ID. */
  public static String getTripNameFromId(String tripId) {
    return String.format(TRIP_NAME_FORMAT, tripId);
  }

  /** Extracts the 'Trip Id' from the Fleet Engine formatted 'Trip name'. */
  public static String getTripIdFromName(String tripName) {
    Matcher matcher = TRIP_NAME_PATTERN.matcher(tripName);
    return matcher.matches() ? matcher.group(2) : null;
  }

  /** Creates exclusive trip with {@code DEFAULT_NUM_PASSENGERS} and given params. */
  public static final Trip createTrip(
      String tripId,
      String vehicleId,
      LatLng pickup,
      LatLng dropoff,
      LatLng[] intermediateDestinationsLatLng,
      TripType tripType) {
    TerminalLocation pickupPoint = TerminalLocation.newBuilder().setPoint(pickup).build();

    TerminalLocation dropoffPoint = TerminalLocation.newBuilder().setPoint(dropoff).build();

    Trip.Builder tripBuilder =
        Trip.newBuilder()
            .setName(getTripNameFromId(tripId))
            .setVehicleId(vehicleId)
            .setTripType(tripType)
            .setPickupPoint(pickupPoint)
            .setDropoffPoint(dropoffPoint)
            .setNumberOfPassengers(DEFAULT_NUM_PASSENGERS);

    if (intermediateDestinationsLatLng != null) {
      tripBuilder.addAllIntermediateDestinations(
          stream(intermediateDestinationsLatLng)
              .map(
                  intermediateDestinationLatLng ->
                      TerminalLocation.newBuilder().setPoint(intermediateDestinationLatLng).build())
              .collect(Collectors.toList()));
    }

    return tripBuilder.build();
  }
}
