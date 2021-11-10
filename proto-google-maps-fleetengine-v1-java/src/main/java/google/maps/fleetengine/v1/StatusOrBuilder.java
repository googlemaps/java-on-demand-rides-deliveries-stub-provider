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

public interface StatusOrBuilder extends
    // @@protoc_insertion_point(interface_extends:maps.fleetengine.v1.Status)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The error code. It is not possible to have a value as 0 if it is explicitly
   * set by the server.
   * </pre>
   *
   * <code>.maps.fleetengine.v1.Status.Code code = 1;</code>
   * @return The enum numeric value on the wire for code.
   */
  int getCodeValue();
  /**
   * <pre>
   * The error code. It is not possible to have a value as 0 if it is explicitly
   * set by the server.
   * </pre>
   *
   * <code>.maps.fleetengine.v1.Status.Code code = 1;</code>
   * @return The code.
   */
  Status.Code getCode();

  /**
   * <pre>
   * Detailed error message.
   * </pre>
   *
   * <code>string message = 2;</code>
   * @return The message.
   */
  String getMessage();
  /**
   * <pre>
   * Detailed error message.
   * </pre>
   *
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <pre>
   * A list of messages that carry the error details.  There is a common set of
   * message types for APIs to use.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any details = 3;</code>
   */
  java.util.List<com.google.protobuf.Any> 
      getDetailsList();
  /**
   * <pre>
   * A list of messages that carry the error details.  There is a common set of
   * message types for APIs to use.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any details = 3;</code>
   */
  com.google.protobuf.Any getDetails(int index);
  /**
   * <pre>
   * A list of messages that carry the error details.  There is a common set of
   * message types for APIs to use.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any details = 3;</code>
   */
  int getDetailsCount();
  /**
   * <pre>
   * A list of messages that carry the error details.  There is a common set of
   * message types for APIs to use.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any details = 3;</code>
   */
  java.util.List<? extends com.google.protobuf.AnyOrBuilder> 
      getDetailsOrBuilderList();
  /**
   * <pre>
   * A list of messages that carry the error details.  There is a common set of
   * message types for APIs to use.
   * </pre>
   *
   * <code>repeated .google.protobuf.Any details = 3;</code>
   */
  com.google.protobuf.AnyOrBuilder getDetailsOrBuilder(
      int index);
}
