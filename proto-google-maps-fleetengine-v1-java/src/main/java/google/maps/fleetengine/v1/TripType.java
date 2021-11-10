/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/maps/fleetengine/v1/fleetengine.proto

package google.maps.fleetengine.v1;

/**
 * <pre>
 * The type of a trip.
 * </pre>
 *
 * Protobuf enum {@code maps.fleetengine.v1.TripType}
 */
public enum TripType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * Default, used for unspecified or unrecognized trip types.
   * </pre>
   *
   * <code>UNKNOWN_TRIP_TYPE = 0;</code>
   */
  UNKNOWN_TRIP_TYPE(0),
  /**
   * <pre>
   * The trip may share a vehicle with other trips.
   * </pre>
   *
   * <code>SHARED = 1;</code>
   */
  SHARED(1),
  /**
   * <pre>
   * The trip is exclusive to a vehicle.
   * </pre>
   *
   * <code>EXCLUSIVE = 2;</code>
   */
  EXCLUSIVE(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * Default, used for unspecified or unrecognized trip types.
   * </pre>
   *
   * <code>UNKNOWN_TRIP_TYPE = 0;</code>
   */
  public static final int UNKNOWN_TRIP_TYPE_VALUE = 0;
  /**
   * <pre>
   * The trip may share a vehicle with other trips.
   * </pre>
   *
   * <code>SHARED = 1;</code>
   */
  public static final int SHARED_VALUE = 1;
  /**
   * <pre>
   * The trip is exclusive to a vehicle.
   * </pre>
   *
   * <code>EXCLUSIVE = 2;</code>
   */
  public static final int EXCLUSIVE_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @Deprecated
  public static TripType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static TripType forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_TRIP_TYPE;
      case 1: return SHARED;
      case 2: return EXCLUSIVE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<TripType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      TripType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<TripType>() {
          public TripType findValueByNumber(int number) {
            return TripType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return FleetEngine.getDescriptor().getEnumTypes().get(0);
  }

  private static final TripType[] VALUES = values();

  public static TripType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private TripType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:maps.fleetengine.v1.TripType)
}

