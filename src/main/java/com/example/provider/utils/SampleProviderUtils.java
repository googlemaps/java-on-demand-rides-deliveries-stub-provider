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

import java.io.IOException;
import java.io.InputStream;

/** Util class for SampleProvider */
public final class SampleProviderUtils {
  public static ProviderProperties providerProperties = createProviderProperties();

  private static final String CONFIG_FILE_PATH = "/config.properties";

  private static ProviderProperties createProviderProperties() {
    try {
      InputStream stream = SampleProviderUtils.class.getResourceAsStream(CONFIG_FILE_PATH);

      providerProperties = SampleProviderPropertiesFactory.create(stream);
    } catch (IOException e) {
      throw new AssertionError("Failed to create ProviderProperties", e);
    }
    return providerProperties;
  }

  private SampleProviderUtils() {}
}
