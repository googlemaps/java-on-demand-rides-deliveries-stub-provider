package com.example.provider.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import google.maps.fleetengine.v1.VehicleAttribute;
import java.lang.reflect.Type;

/** JSON serializer for vehicleAttribute objects. */
public class VehicleAttributeSerializer implements JsonSerializer<VehicleAttribute> {

  @Override
  public JsonElement serialize(
      VehicleAttribute src, Type typeOfSrc, JsonSerializationContext context) {
    SerializedVehicleAttribute vehicleAttribute =
        SerializedVehicleAttribute.newBuilder()
            .setKey(src.getKey())
            .setValue(src.getValue())
            .build();
    return new Gson().toJsonTree(vehicleAttribute);
  }
}
