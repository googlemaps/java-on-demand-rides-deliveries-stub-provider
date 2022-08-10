package com.example.provider.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import google.maps.fleetengine.v1.VehicleAttribute;
import java.lang.reflect.Type;

/** JSON deserializer for vehicleAttribute objects. */
final class VehicleAttributeDeserializer implements JsonDeserializer<VehicleAttribute> {
  private static final String KEY_FIELD = "key";
  private static final String VALUE_FIELD = "value";
  private static final String NOT_PROVIDED_MESSAGE = "%s not provided";

  @Override
  public VehicleAttribute deserialize(
      JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    JsonObject jsonObject = json.getAsJsonObject();

    if (!jsonObject.has(KEY_FIELD)) {
      String errorMsg = String.format(NOT_PROVIDED_MESSAGE, KEY_FIELD);
      throw new JsonParseException(errorMsg);
    }

    if (!jsonObject.has(VALUE_FIELD)) {
      String errorMsg = String.format(NOT_PROVIDED_MESSAGE, VALUE_FIELD);
      throw new JsonParseException(errorMsg);
    }

    String vehicleAttributeKey = jsonObject.get(KEY_FIELD).getAsString();
    String vehicleAttributeValue = jsonObject.get(VALUE_FIELD).getAsString();

    return VehicleAttribute.newBuilder()
        .setKey(vehicleAttributeKey)
        .setValue(vehicleAttributeValue)
        .build();
  }
}
