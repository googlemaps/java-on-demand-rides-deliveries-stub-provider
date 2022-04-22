/* Copyright 2022 Google LLC
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
package com.example.provider.json;

import com.google.auto.value.AutoValue;

/** Representation of terminal location. */
@AutoValue
abstract class SerializedLatLng {

  abstract double latitude();

  abstract double longitude();

  // For backward compatibility.
  abstract double latitude_();

  // For backward compatibility.
  abstract double longitude_();

  static Builder newBuilder() {
    return new AutoValue_SerializedLatLng.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setLatitude(double latitude);

    abstract Builder setLongitude(double longitude);

    abstract Builder setLatitude_(double latitude_);

    abstract Builder setLongitude_(double longitude_);

    abstract SerializedLatLng build();
  }
}
