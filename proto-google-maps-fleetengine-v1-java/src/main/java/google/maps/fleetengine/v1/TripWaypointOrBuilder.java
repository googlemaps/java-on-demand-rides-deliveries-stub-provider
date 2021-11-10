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

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/maps/fleetengine/v1/fleetengine.proto

package google.maps.fleetengine.v1;

public interface TripWaypointOrBuilder extends
    // @@protoc_insertion_point(interface_extends:maps.fleetengine.v1.TripWaypoint)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The location where this waypoint is
   * </pre>
   *
   * <code>.maps.fleetengine.v1.TerminalLocation location = 1;</code>
   * @return Whether the location field is set.
   */
  boolean hasLocation();
  /**
   * <pre>
   * The location where this waypoint is
   * </pre>
   *
   * <code>.maps.fleetengine.v1.TerminalLocation location = 1;</code>
   * @return The location.
   */
  TerminalLocation getLocation();
  /**
   * <pre>
   * The location where this waypoint is
   * </pre>
   *
   * <code>.maps.fleetengine.v1.TerminalLocation location = 1;</code>
   */
  TerminalLocationOrBuilder getLocationOrBuilder();

  /**
   * <pre>
   * The trip this waypoint is part of
   * </pre>
   *
   * <code>string trip_id = 2;</code>
   * @return The tripId.
   */
  String getTripId();
  /**
   * <pre>
   * The trip this waypoint is part of
   * </pre>
   *
   * <code>string trip_id = 2;</code>
   * @return The bytes for tripId.
   */
  com.google.protobuf.ByteString
      getTripIdBytes();

  /**
   * <pre>
   * The type described the role the waypoint plays for this trip such as a
   * pickup or dropoff.
   * </pre>
   *
   * <code>.maps.fleetengine.v1.WaypointType waypoint_type = 3;</code>
   * @return The enum numeric value on the wire for waypointType.
   */
  int getWaypointTypeValue();
  /**
   * <pre>
   * The type described the role the waypoint plays for this trip such as a
   * pickup or dropoff.
   * </pre>
   *
   * <code>.maps.fleetengine.v1.WaypointType waypoint_type = 3;</code>
   * @return The waypointType.
   */
  WaypointType getWaypointType();

  /**
   * <pre>
   * The path calculated by Fleet Engine from the previous waypoint to the
   * current waypoint.
   * </pre>
   *
   * <code>repeated .google.type.LatLng path_to_waypoint = 4;</code>
   */
  java.util.List<com.google.type.LatLng> 
      getPathToWaypointList();
  /**
   * <pre>
   * The path calculated by Fleet Engine from the previous waypoint to the
   * current waypoint.
   * </pre>
   *
   * <code>repeated .google.type.LatLng path_to_waypoint = 4;</code>
   */
  com.google.type.LatLng getPathToWaypoint(int index);
  /**
   * <pre>
   * The path calculated by Fleet Engine from the previous waypoint to the
   * current waypoint.
   * </pre>
   *
   * <code>repeated .google.type.LatLng path_to_waypoint = 4;</code>
   */
  int getPathToWaypointCount();
  /**
   * <pre>
   * The path calculated by Fleet Engine from the previous waypoint to the
   * current waypoint.
   * </pre>
   *
   * <code>repeated .google.type.LatLng path_to_waypoint = 4;</code>
   */
  java.util.List<? extends com.google.type.LatLngOrBuilder> 
      getPathToWaypointOrBuilderList();
  /**
   * <pre>
   * The path calculated by Fleet Engine from the previous waypoint to the
   * current waypoint.
   * </pre>
   *
   * <code>repeated .google.type.LatLng path_to_waypoint = 4;</code>
   */
  com.google.type.LatLngOrBuilder getPathToWaypointOrBuilder(
      int index);

  /**
   * <pre>
   * The path distance calculated by Fleet Engine from the previous waypoint to
   * the current waypoint.
   * If the current waypoint is the first waypoint in the list (Vehicle.waypoint
   * or Trip.remaining_waypoints), then the starting point is the vehicle's
   * location recorded at the time this TripWaypoint was added to the list.
   * </pre>
   *
   * <code>.google.protobuf.Int32Value distance_meters = 6;</code>
   * @return Whether the distanceMeters field is set.
   */
  boolean hasDistanceMeters();
  /**
   * <pre>
   * The path distance calculated by Fleet Engine from the previous waypoint to
   * the current waypoint.
   * If the current waypoint is the first waypoint in the list (Vehicle.waypoint
   * or Trip.remaining_waypoints), then the starting point is the vehicle's
   * location recorded at the time this TripWaypoint was added to the list.
   * </pre>
   *
   * <code>.google.protobuf.Int32Value distance_meters = 6;</code>
   * @return The distanceMeters.
   */
  com.google.protobuf.Int32Value getDistanceMeters();
  /**
   * <pre>
   * The path distance calculated by Fleet Engine from the previous waypoint to
   * the current waypoint.
   * If the current waypoint is the first waypoint in the list (Vehicle.waypoint
   * or Trip.remaining_waypoints), then the starting point is the vehicle's
   * location recorded at the time this TripWaypoint was added to the list.
   * </pre>
   *
   * <code>.google.protobuf.Int32Value distance_meters = 6;</code>
   */
  com.google.protobuf.Int32ValueOrBuilder getDistanceMetersOrBuilder();

  /**
   * <pre>
   * The arrival time to this waypoint calculated by Fleet Engine.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp eta = 7;</code>
   * @return Whether the eta field is set.
   */
  boolean hasEta();
  /**
   * <pre>
   * The arrival time to this waypoint calculated by Fleet Engine.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp eta = 7;</code>
   * @return The eta.
   */
  com.google.protobuf.Timestamp getEta();
  /**
   * <pre>
   * The arrival time to this waypoint calculated by Fleet Engine.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp eta = 7;</code>
   */
  com.google.protobuf.TimestampOrBuilder getEtaOrBuilder();

  /**
   * <pre>
   * The travel time from previous waypoint to this point.
   * If the current waypoint is the first waypoint in the list (Vehicle.waypoint
   * or Trip.remaining_waypoints), then the starting point is the vehicle's
   * location recorded at the time that this waypoint was added to the list.
   * This field is filled only when returning Trip/Vehicle data.
   * </pre>
   *
   * <code>.google.protobuf.Duration duration = 8;</code>
   * @return Whether the duration field is set.
   */
  boolean hasDuration();
  /**
   * <pre>
   * The travel time from previous waypoint to this point.
   * If the current waypoint is the first waypoint in the list (Vehicle.waypoint
   * or Trip.remaining_waypoints), then the starting point is the vehicle's
   * location recorded at the time that this waypoint was added to the list.
   * This field is filled only when returning Trip/Vehicle data.
   * </pre>
   *
   * <code>.google.protobuf.Duration duration = 8;</code>
   * @return The duration.
   */
  com.google.protobuf.Duration getDuration();
  /**
   * <pre>
   * The travel time from previous waypoint to this point.
   * If the current waypoint is the first waypoint in the list (Vehicle.waypoint
   * or Trip.remaining_waypoints), then the starting point is the vehicle's
   * location recorded at the time that this waypoint was added to the list.
   * This field is filled only when returning Trip/Vehicle data.
   * </pre>
   *
   * <code>.google.protobuf.Duration duration = 8;</code>
   */
  com.google.protobuf.DurationOrBuilder getDurationOrBuilder();
}
