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

public interface FormattedAddressOrBuilder extends
    // @@protoc_insertion_point(interface_extends:maps.fleetengine.v1.FormattedAddress)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The lines of text that describe the address.
   * At least one line must be present.
   * </pre>
   *
   * <code>repeated string lines = 1;</code>
   * @return A list containing the lines.
   */
  java.util.List<String>
      getLinesList();
  /**
   * <pre>
   * The lines of text that describe the address.
   * At least one line must be present.
   * </pre>
   *
   * <code>repeated string lines = 1;</code>
   * @return The count of lines.
   */
  int getLinesCount();
  /**
   * <pre>
   * The lines of text that describe the address.
   * At least one line must be present.
   * </pre>
   *
   * <code>repeated string lines = 1;</code>
   * @param index The index of the element to return.
   * @return The lines at the given index.
   */
  String getLines(int index);
  /**
   * <pre>
   * The lines of text that describe the address.
   * At least one line must be present.
   * </pre>
   *
   * <code>repeated string lines = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the lines at the given index.
   */
  com.google.protobuf.ByteString
      getLinesBytes(int index);
}
