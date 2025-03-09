[![Tests/Build](https://github.com/googlemaps/java-on-demand-rides-deliveries-stub-provider/actions/workflows/test.yml/badge.svg)](https://github.com/googlemaps/java-on-demand-rides-deliveries-stub-provider/actions/workflows/test.yml)

![Contributors](https://img.shields.io/github/contributors/googlemaps/java-on-demand-rides-deliveries-stub-provider?color=green)
[![License](https://img.shields.io/github/license/googlemaps/java-on-demand-rides-deliveries-stub-provider?color=blue)][license]
[![StackOverflow](https://img.shields.io/stackexchange/stackoverflow/t/google-maps?color=orange&label=google-maps&logo=stackoverflow)](https://stackoverflow.com/questions/tagged/google-maps)
[![Discord](https://img.shields.io/discord/676948200904589322?color=6A7EC2&logo=discord&logoColor=ffffff)][Discord server]

# Java On-Demand Rides and Deliveries Stub Provider Sample App

## Description

This repo features a sample app server, a basic Provider implementation for the Journey Sharing Sample
Apps that will communicate with Fleet Engine. It is a standalone server
providing endpoints that Journey Sharing Sample Apps can use to create
vehicles/trips and all the necessary requirements of Journey Sharing for a
single exclusive ride.

## Requirements

- [Sign up with Google Maps Platform]
- A Google Maps Platform [project] with **App Engine** and the **Fleet Engine APIs** enabled
- An [API key] associated with the project above
- Gradle and Java 11+

## Installation

The server uses the Fleet Engine Auth Library to sign JWTs. This allows
for authenticated communications with Fleet Engine. In order to run it properly,
it's expected that you have set up the proper service accounts. To learn more,
see the
[Fleet Engine Auth Library repository](https://github.com/googlemaps/java-fleetengine-auth).

By default, the sample provider signs JWTs using impersonation
instead of credential files. Impersonation is the preferred
method when signing JWTs because it's inherently more secure than downloading
credential files.

The service account names are configured within
[./src/main/resources/config.properties](./src/main/resources/config.properties)

If impersonation is not an option for you, you can
switch signers by modifying the `provideMinter` method within
[./src/main/java/com/example/provider/SampleServletModule.java](./src/main/java/com/example/provider/SampleServletModule.java)

## Running or deploying the Server with Gradle

This sample provider is running App Engine with Gradle. For more information
regarding the App Engine plugin with Gradle, go to this
[website](https://cloud.google.com/appengine/docs/standard/java/using-gradle).

Install and configure the following prerequisites:

- Make sure your environment is set to Java 17.
- Make sure that your Cloud project is set up on your Google account. Go to
  [Setting up and validating your Cloud project](https://cloud.google.com/appengine/docs/standard/java/using-gradle#setting_up_and_validating_your)
- [gcloud CLI tool](https://cloud.google.com/sdk/install).

## Usage

1. Make sure that the user running the sample provider has the Service Account
   Token Creator role by following
   [these instructions](https://developers.google.com/maps/documentation/transportation-logistics/on-demand-rides-deliveries-solution/fleet-engine/auth).
2. Update `src/main/resources/config.properties` with the provider ID and
   service account information
3. Authenticate the current environment by setting the application default
   credentials. `gcloud auth application-default login`.
4. This will redirect to signin with your gmail.
5. Go to the root folder of this project.
6. Run `./gradlew appengineRun`.
7. Check that the server is running and accessible on http://10.0.2.2:8080 from the Android Studio
   Emulator.
8. To exit the server, there's a Java application that starts up. Quit out of
   the application to exit the server. You can also run `ps auxw | grep java`
   to find the PIDs and then do `kill $pid1 $pid2` to kill the process that's
   running the Java application. Note: there are always two matching PIDs
   because the Java process forks itself.

### To deploy to App Engine

1. Make sure that the user running the *App Engine* has the Service Account
   Token Creator role by following
   [these instructions](https://developers.google.com/maps/documentation/transportation-logistics/on-demand-rides-deliveries-solution/fleet-engine/auth).
   The `App Engine default service account` default has this format:
   YOUR-CLOUD-PROJECT@appspot.gserviceaccount.com
2. Update `src/main/resources/config.properties` with the provider ID and
   service account information.
3. Update `YOUR-CLOUD-PROJECT` in your build.gradle to your *App Engine* project.
4. Update `YOUR-APPID-HERE` in your `src/main/webapp/WEB-INF/appengine-web.xml` file.
5. Authenticate the current environment by setting the application default
   credentials. `gcloud auth application-default login`.
6. This will redirect to signin with your gmail.
7. Go to the root folder of this project.
8. Run `./gradlew appengineDeploy`.
9. Check that the server is running on https://YOUR-CLOUD-PROJECT.as.r.appspot.com/

## Frequent Errors

`Caused by: java.lang.NoSuchMethodException: java.net.SocksSocketImpl.<init>()` or
`Exception java.lang.NoClassDefFoundError: Could not initialize class org.codehaus.groovy.reflection.ReflectionCache [in thread "Daemon worker"]`

- Make sure to set 11. We recommend [SDKMan](https://sdkman.io/usage) to manage this in your system.

`Error injecting constructor, com.google.auth.ServiceAccountSigner$SigningException: Failed to sign the provided bytes`

- Fill in the required Fleet Engine configuration in `src/main/resources/config.properties`.

## Endpoints

These are the supported endpoints and how to interact with them:

### Token

#### GET

Retrieves a signed JWT to be used to communicate with the Fleet Engine. The
token will expire after 60 minutes of its creation.

```
GET /token/driver/:vehicleId
GET /token/consumer/:tripId
```

Sample response:

```json
{
  "jwt": "abcdefgh01234567",
  "creationTimestamp": 1650500000000,
  "expirationTimestamp": 1650503600000
}
```

### Vehicle

#### GET

Retrieves the Fleet Engine specification of a registered vehicle. A vehicle ID
(the vehicle name provided on its creation) should be provided in order to fetch
its information.

```
GET /vehicle/:vehicleId
```

Sample response:

```json
{
  "name": "providers/testProvider/vehicles/testVehicle",
  "vehicleState": "ONLINE",
  "currentTripsIds": [
    "testTrip"
  ],
  "waypoints": [
    {
      "location": {
        "point": {
          "latitude": 3.45,
          "longitude": 4.4
        }
      },
      "waypointType": "PICKUP_WAYPOINT_TYPE",
      "tripId": "testTrip"
    },
    {
      "location": {
        "point": {
          "latitude": 3.44,
          "longitude": 4.43
        }
      },
      "waypointType": "DROP_OFF_WAYPOINT_TYPE",
      "tripId": "testTrip"
    }
  ],
  "supportedTripTypes": [
    "EXCLUSIVE"
  ],
  "backToBackEnabled": true,
  "maximumCapacity": 5
}
```

#### POST

Creates a new vehicle given the vehicle ID. The vehicle ID is given in the body
with the field `vehicleId`. The attributes that can be specified
are: `supportedTripTypes`, `backToBackEnabled`, and `maximumCapacity`.

```
POST /vehicle/new
```

Sample request body:

```json
{
  "vehicleId": "testVehicle",
  "supportedTripTypes": [
    "EXCLUSIVE"
  ],
  "backToBackEnabled": false,
  "maximumCapacity": 5
}
```

#### PUT

Updates a vehicle with the attributes provided. The vehicle ID is supplied in the url path.
The attributes that can be modified are: `supportedTripTypes`, `backToBackEnabled`,
and `maximumCapacity`.

```
PUT /vehicle/:vehicleId
```

Sample request body:

```json
{
  "supportedTripTypes": [
    "EXCLUSIVE"
  ],
  "backToBackEnabled": false,
  "maximumCapacity": 5
}
```

### Trip

#### GET

Retrieves the Fleet Engine specification of a registered trip. If registered a
trip object will be returned even if there is no match for it yet. Once a trip
match is found it will be included in the response. If the trip ID is not
specified, the most recent trip is return.

```
GET /trip/:tripId
```

Sample response:

```json
{
  "trip": {
    "name": "providers/testProvider/trips/testTrip",
    "vehicleId": "testVehicle",
    "tripStatus": "ENROUTE_TO_PICKUP",
    "waypoints": [
      {
        "location": {
          "point": {
            "latitude": 3.45,
            "longitude": 4.4
          }
        },
        "waypointType": "PICKUP_WAYPOINT_TYPE",
        "tripId": "testTrip"
      },
      {
        "location": {
          "point": {
            "latitude": 3.44,
            "longitude": 4.43
          }
        },
        "waypointType": "DROP_OFF_WAYPOINT_TYPE",
        "tripId": "testTrip"
      }
    ]
  }
}
```

#### POST

Creates a new trip given the JSON provided by the body of the POST. The pickup
and the dropoff points are provided and a new trip is configured. If there is an
existing vehicle, the sample provider will match the vehicle with the trip.

The `intermediateDestinations` field is optional and it's used to support multi-destination trips.

The `tripType` field is optional. The possible values are `EXCLUSIVE` and `SHARED`. In case it is
not provided, the provider will default to `EXCLUSIVE`.

```
POST /trip/new
```

Sample request body:

```json
{
  "pickup": {
    "latitude": 3.45,
    "longitude": 4.4
  },
  "dropoff": {
    "latitude": 3.44,
    "longitude": 4.43
  },
  "intermediateDestinations": [
    {
      "latitude": 4.44,
      "longitude": 4.43
    },
    {
      "latitude": 5.44,
      "longitude": 2.43
    }
  ],
  "tripType": "EXCLUSIVE"
}
```

#### PUT

Updates the status of a trip given the trip ID. The status is given in the body
with the field `status`. An optional `intermediateDestinationIndex` field can be passed in case this
is a multi-destination trip and driver is moving between intermediate destinations.

```
PUT /trip/:tripId
```

Sample request body:

```json
{
  "status": "NEW"
}
```

Sample request body (updating intermediate destination pointer):

```json
{
   "status": "ENROUTE_TO_INTERMEDIATE_DESTINATION",
   "intermediateDestinationIndex": 0
}
```

## Contributing

Contributions are welcome and encouraged! If you'd like to contribute, send us a [pull request] and refer to our [code of conduct] and [contributing guide].

## Terms of Service

This library uses Google Maps Platform services. Use of Google Maps Platform services through this library is subject to the Google Maps Platform [Terms of Service].

This library is not a Google Maps Platform Core Service. Therefore, the Google Maps Platform Terms of Service (e.g. Technical Support Services, Service Level Agreements, and Deprecation Policy) do not apply to the code in this library.

## Support

This library is offered via an open source [license]. It is not governed by the Google Maps Platform Support [Technical Support Services Guidelines, the SLA, or the [Deprecation Policy]. However, any Google Maps Platform services used by the library remain subject to the Google Maps Platform Terms of Service.

This library adheres to [semantic versioning] to indicate when backwards-incompatible changes are introduced. Accordingly, while the library is in version 0.x, backwards-incompatible changes may be introduced at any time.

If you find a bug, or have a feature request, please [file an issue] on GitHub. If you would like to get answers to technical questions from other Google Maps Platform developers, ask through one of our [developer community channels]. If you'd like to contribute, please check the [contributing guide].

You can also discuss this library on our [Discord server].

[API key]: https://developers.google.com/maps/documentation/javascript/get-api-key
[maps-sdk]: https://developers.google.com/maps/documentation/mobility
[documentation]: https://googlemaps.github.io/java-on-demand-rides-deliveries-stub-provider

[code of conduct]: ?tab=coc-ov-file#readme
[contributing guide]: CONTRIBUTING.md
[Deprecation Policy]: https://cloud.google.com/maps-platform/terms
[developer community channels]: https://developers.google.com/maps/developer-community
[Discord server]: https://discord.gg/hYsWbmk
[file an issue]: https://github.com/googlemaps/java-on-demand-rides-deliveries-stub-provider/issues/new/choose
[license]: LICENSE
[project]: https://developers.google.com/maps/documentation/mobility/fleet-engine/essentials/set-up-fleet/create-project
[pull request]: https://github.com/googlemaps/java-on-demand-rides-deliveries-stub-provider/compare
[semantic versioning]: https://semver.org
[Sign up with Google Maps Platform]: https://console.cloud.google.com/google/maps-apis/start
[similar inquiry]: https://github.com/googlemaps/java-on-demand-rides-deliveries-stub-provider/issues
[SLA]: https://cloud.google.com/maps-platform/terms/sla
[Technical Support Services Guidelines]: https://cloud.google.com/maps-platform/terms/tssg
[Terms of Service]: https://cloud.google.com/maps-platform/terms

