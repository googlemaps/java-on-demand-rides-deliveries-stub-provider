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

import com.google.auto.value.AutoValue;

/** Holds Properties used in the Provider. */
@AutoValue
public abstract class ProviderProperties {

  public static ProviderProperties create(
      String providerId,
      String fleetEngineAddress,
      String serverTokenAccountName,
      String consumerTokenAccountName,
      String driverTokenAccountName,
      String fleetEngineAudience) {
    return new AutoValue_ProviderProperties(
        providerId,
        fleetEngineAddress,
        serverTokenAccountName,
        consumerTokenAccountName,
        driverTokenAccountName,
        fleetEngineAudience);
  }

  public abstract String providerId();

  public abstract String fleetEngineAddress();

  public abstract String serverTokenAccountName();

  public abstract String consumerTokenAccountName();

  public abstract String driverTokenAccountName();

  public abstract String fleetEngineAudience();
}
