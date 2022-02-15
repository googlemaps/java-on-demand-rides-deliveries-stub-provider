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

import com.google.protobuf.DoubleValue;
import com.google.protobuf.Int32Value;
import com.google.type.LatLng;

/** Util class for easy way to create protos values. */
final class ProtosUtil {
  static Int32Value getIntValue(int value) {
    return Int32Value.of(value);
  }

  static DoubleValue getDoubleValue(double value) {
    return DoubleValue.of(value);
  }

  static LatLng getLatLng(double latitude, double longitude) {
    return LatLng.newBuilder().setLatitude(latitude).setLongitude(longitude).build();
  }

  private ProtosUtil() {}
}
