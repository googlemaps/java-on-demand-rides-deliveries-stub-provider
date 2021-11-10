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
// source: google/maps/fleetengine/v1/vehicle_api.proto

package google.maps.fleetengine.v1;

public interface VehicleAttributeListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:maps.fleetengine.v1.VehicleAttributeList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  java.util.List<VehicleAttribute>
      getAttributesList();
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  VehicleAttribute getAttributes(int index);
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  int getAttributesCount();
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  java.util.List<? extends VehicleAttributeOrBuilder>
      getAttributesOrBuilderList();
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  VehicleAttributeOrBuilder getAttributesOrBuilder(
      int index);
}
