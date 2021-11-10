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

import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Factory class for ProviderProperties. */
public final class SampleProviderPropertiesFactory {

  @VisibleForTesting static final String FLEET_ENGINE_ADDRESS_PROP_KEY = "fleetengine-address";

  @VisibleForTesting static final String PROVIDER_ID_PROP_KEY = "provider-id";

  @VisibleForTesting static final String SERVER_TOKEN_ACCOUNT_NAME = "server-token-account";

  @VisibleForTesting static final String CONSUMER_TOKEN_ACCOUNT_NAME = "consumer-token-account";

  @VisibleForTesting static final String DRIVER_TOKEN_ACCOUNT_NAME = "driver-token-account";

  @VisibleForTesting static final String FLEET_ENGINE_AUDIENCE = "fleetengine-audience";

  private SampleProviderPropertiesFactory() {}

  /** Creates {@code ProviderProperties} from params. */
  public static ProviderProperties create(
      final String providerId,
      final String fleetEngineAddress,
      final String serverTokenAccountName,
      final String consumerTokenAccountName,
      final String driverTokenAccountName,
      final String fleetEngineAudience) {
    return ProviderProperties.create(
        providerId,
        fleetEngineAddress,
        serverTokenAccountName,
        consumerTokenAccountName,
        driverTokenAccountName,
        fleetEngineAudience);
  }

  /**
   * Creates {@code ProviderProperties} from properties in {@code InputStream}.
   *
   * @throws IOException if an error occurs when writing stream to {@code providerProperties}
   */
  public static ProviderProperties create(InputStream stream) throws IOException {
    Properties properties = loadPropertiesFromInputStream(stream);
    return create(
        getPropertyFromKey(properties, PROVIDER_ID_PROP_KEY),
        getPropertyFromKey(properties, FLEET_ENGINE_ADDRESS_PROP_KEY),
        getPropertyFromKey(properties, SERVER_TOKEN_ACCOUNT_NAME),
        getPropertyFromKey(properties, CONSUMER_TOKEN_ACCOUNT_NAME),
        getPropertyFromKey(properties, DRIVER_TOKEN_ACCOUNT_NAME),
        getPropertyFromKey(properties, FLEET_ENGINE_AUDIENCE));
  }

  /**
   * Loads properties from an {@code InputStream}.
   *
   * @throws IOException if an error occurs when writing stream to {@code providerProperties}
   */
  private static Properties loadPropertiesFromInputStream(InputStream stream) throws IOException {
    Properties properties = new Properties();
    properties.load(stream);
    return properties;
  }

  /**
   * Returns the value for a given property.
   *
   * @throws IllegalArgumentException if a property with given key does not exist
   */
  private static String getPropertyFromKey(Properties properties, String propertyKey) {
    String propertyValue = properties.getProperty(propertyKey);
    if (propertyValue == null) {
      throw new IllegalArgumentException(
          String.format("Could not find expected property '%s'", propertyKey));
    }
    return propertyValue;
  }
}
