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
package com.example.provider;

import com.example.provider.auth.grpcservice.GrpcServiceModule;
import com.example.provider.utils.SampleProviderUtils;
import com.google.common.base.Strings;
import com.google.fleetengine.auth.AuthTokenMinter;
import com.google.fleetengine.auth.token.factory.FleetEngineTokenFactory;
import com.google.fleetengine.auth.token.factory.FleetEngineTokenFactorySettings;
import com.google.fleetengine.auth.token.factory.signer.ImpersonatedSigner;
import com.google.fleetengine.auth.token.factory.signer.SignerInitializationException;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

/** Module for configuring routes for this sample provider. */
public final class SampleServletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    super.configureServlets();
    install(new GrpcServiceModule());

    serve("/vehicle/*").with(VehicleServlet.class);
    serve("/vehicles/*").with(VehiclesServlet.class);
    serve("/trip").with(TripServlet.class);
    serve("/trip/*").with(TripServlet.class);
    serve("/token/*").with(TokenServlet.class);
  }

  @Provides
  @Singleton
  AuthTokenMinter provideMinter() throws SignerInitializationException {
    AuthTokenMinter.Builder builder =
        AuthTokenMinter.builder()
            .setTokenFactory(
                new FleetEngineTokenFactory(
                    FleetEngineTokenFactorySettings.builder()
                        .setAudience(SampleProviderUtils.providerProperties.fleetEngineAudience())
                        .build()));

    if (!Strings.isNullOrEmpty(SampleProviderUtils.providerProperties.serverTokenAccountName())) {
      builder.setServerSigner(
          ImpersonatedSigner.create(
              SampleProviderUtils.providerProperties.serverTokenAccountName()));
    }
    if (!Strings.isNullOrEmpty(SampleProviderUtils.providerProperties.consumerTokenAccountName())) {
      builder.setConsumerSigner(
          ImpersonatedSigner.create(
              SampleProviderUtils.providerProperties.consumerTokenAccountName()));
    }
    if (!Strings.isNullOrEmpty(SampleProviderUtils.providerProperties.driverTokenAccountName())) {
      builder.setDriverSigner(
          ImpersonatedSigner.create(
              SampleProviderUtils.providerProperties.driverTokenAccountName()));
    }
    return builder.build();
  }
}
