# Sample App Server

This server is a basic Provider implementation for the Journey Sharing Sample
Apps that will communicate with Fleet Engine. It is a standalone server
providing endpoints that Journey Sharing Sample Apps can use to create
vehicles/trips and all the necessary requirements of Journey Sharing for a
single exclusive ride.


This is a test.

## Setup

The server uses the Fleet Engine Auth Library to sign JWTs.  This allows
for authenticated communications with Fleet Engine. In order to run it properly,
it's expected that you have set up the proper service accounts. To learn more,
see the
[Fleet Engine Auth Library repository](https://github.com/googlemaps/java-fleetengine-auth).

By default, the sample provider signs JWTs using impersonation
instead of credential files.  Impersonation is the preferred
method when signing JWTs because it's inherently more secure than downloading
credential files.

The service account names are configured within
[./src/main/resources/config.properties](./src/main/resources/config.properties)

If impersonation is not an option for you, you can
switch signers by modifying the `provideMinter` method within
[./src/main/java/com/example/provider/SampleServletModule.java](./src/main/java/com/example/provider/SampleServletModule.java)


## Running Server with Gradle

This sample provider is running App Engine with Gradle. For more information
regarding the App Engine plugin with Gradle, go to this
[website](https://cloud.google.com/appengine/docs/standard/java/using-gradle).

Install and configure the following prerequisites:
- Java 8 (if a newer Java version is installed, set the Java version to 8).
  There is an issue with the App Engine plugin and newer versions of Java. To set
  the version to 8, run this command:
  `` export JAVA_HOME=`/usr/libexec/java_home -v 1.8` ``
- Make sure that your Cloud project is set up on your Google account. Go to
  [Setting up and validating your Cloud project](https://cloud.google.com/appengine/docs/standard/java/using-gradle#setting_up_and_validating_your)
- [gcloud CLI tool](https://cloud.google.com/sdk/install).

To run the server:
1. Make sure that the user running the sample provider has the Service Account
   Token Creator role by following
   [these instructions](https://developers.google.com/maps/documentation/transportation-logistics/on-demand-rides-deliveries-solution/fleet-engine/auth).
2. Update `src/main/resources/config.properties` with the provider ID and
   service account information
3. Authenticate the current environment by setting the application default
   credentials. `gcloud auth application-default login`.
4. This will redirect to signin with your gmail.
5. Go to the root folder of this provider.
6. Run `./gradlew appengineRun`.
7. Check that the server is running on http://10.0.2.2:8080.
8. To exit the server, there's a Java application that starts up. Quit out of
   the application to exit the server. You can also run `ps auxw | grep java`
   to find the PIDs and then do `kill $pid1 $pid2` to kill the process that's
   running the Java application. Note: there are always two matching PIDs
   because the Java process forks itself.

## Frequent Errors

`Caused by: java.lang.NoSuchMethodException: java.net.SocksSocketImpl.<init>()`
- Set the Java version to 8 by running the command
  `` export JAVA_HOME=`/usr/libexec/java_home -v 1.8` ``.

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
  "currentTripsIds": ["testTrip"],
  "waypoints": [
    {
      "location": {
        "point": { "latitude": 3.45, "longitude": 4.4 }
      },
      "waypointType": "PICKUP_WAYPOINT_TYPE",
      "tripId": "testTrip"
    },
    {
      "location": {
        "point": { "latitude": 3.44, "longitude": 4.43 }
      },
      "waypointType": "DROP_OFF_WAYPOINT_TYPE",
      "tripId": "testTrip"
    }
  ],
  "supportedTripTypes": ["EXCLUSIVE"],
  "backToBackEnabled": true,
  "maximumCapacity": 5
}
```

#### POST

Creates a new vehicle given the vehicle ID. The vehicle ID is given in the body
with the field `vehicleId`. The attributes that can be specified are: `supportedTripTypes`, `backToBackEnabled`, and `maximumCapacity`.


```
POST /vehicle/new
```

Sample request body:
```json
{
  "vehicleId": "testVehicle",
  "supportedTripTypes": ["EXCLUSIVE"],
  "backToBackEnabled": false,
  "maximumCapacity": 5
}
```

#### PUT

Updates a vehicle with the attributes provided. The vehicle ID is supplied in the url path.
The attributes that can be modified are: `supportedTripTypes`, `backToBackEnabled`, and `maximumCapacity`.

```
PUT /vehicle/:vehicleId
```

Sample request body:
```json
{
  "supportedTripTypes": ["EXCLUSIVE"],
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
          "point": { "latitude": 3.45, "longitude": 4.4 }
        },
        "waypointType": "PICKUP_WAYPOINT_TYPE",
        "tripId": "testTrip"
      },
      {
        "location": {
          "point": { "latitude": 3.44, "longitude": 4.43 }
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

The `tripType` field is optional. The possible values are `EXCLUSIVE` and `SHARED`. In case it is not provided, the provider will default to `EXCLUSIVE`.
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
with the field `status`. An optional `intermediateDestinationIndex` field can be passed in case this is a multi-destination trip and driver is moving between intermediate destinations.

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
