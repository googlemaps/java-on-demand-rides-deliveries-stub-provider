package com.example.provider.json;

import com.google.auto.value.AutoValue;

/** Class used to represent a serialized VehicleAttribute object. */
@AutoValue
abstract class SerializedVehicleAttribute {

  /** Key of the vehicle attribute. */
  abstract String key();

  /** Value of the vehicle attribute. */
  abstract String value();

  static Builder newBuilder() {
    return new AutoValue_SerializedVehicleAttribute.Builder();
  }

  /** Builder for this serialized vehicle attribute. */
  @AutoValue.Builder
  abstract static class Builder {

    abstract Builder setKey(String key);

    abstract Builder setValue(String value);

    abstract SerializedVehicleAttribute build();
  }
}
