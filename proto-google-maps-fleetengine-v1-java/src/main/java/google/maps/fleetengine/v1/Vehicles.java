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
// source: google/maps/fleetengine/v1/vehicles.proto

package google.maps.fleetengine.v1;

public final class Vehicles {
  private Vehicles() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_maps_fleetengine_v1_Vehicle_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_maps_fleetengine_v1_Vehicle_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_maps_fleetengine_v1_Vehicle_VehicleType_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_maps_fleetengine_v1_Vehicle_VehicleType_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_maps_fleetengine_v1_BatteryInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_maps_fleetengine_v1_BatteryInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_maps_fleetengine_v1_DeviceSettings_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_maps_fleetengine_v1_DeviceSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_maps_fleetengine_v1_LicensePlate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_maps_fleetengine_v1_LicensePlate_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n)google/maps/fleetengine/v1/vehicles.pr" +
      "oto\022\023maps.fleetengine.v1\032\037google/api/fie" +
      "ld_behavior.proto\032\031google/api/resource.p" +
      "roto\032,google/maps/fleetengine/v1/fleeten" +
      "gine.proto\032\037google/protobuf/timestamp.pr" +
      "oto\032\036google/protobuf/wrappers.proto\"\350\n\n\007" +
      "Vehicle\022\014\n\004name\030\001 \001(\t\0228\n\rvehicle_state\030\002" +
      " \001(\0162!.maps.fleetengine.v1.VehicleState\022" +
      ";\n\024supported_trip_types\030\003 \003(\0162\035.maps.fle" +
      "etengine.v1.TripType\022\025\n\rcurrent_trips\030\004 " +
      "\003(\t\022;\n\rlast_location\030\005 \001(\0132$.maps.fleete" +
      "ngine.v1.VehicleLocation\022\030\n\020maximum_capa" +
      "city\030\006 \001(\005\022\032\n\022available_capacity\030\007 \001(\005\0229" +
      "\n\nattributes\030\010 \003(\0132%.maps.fleetengine.v1" +
      ".VehicleAttribute\022>\n\014vehicle_type\030\t \001(\0132" +
      "(.maps.fleetengine.v1.Vehicle.VehicleTyp" +
      "e\0228\n\rlicense_plate\030\n \001(\0132!.maps.fleeteng" +
      "ine.v1.LicensePlate\0228\n\005route\030\014 \003(\0132%.map" +
      "s.fleetengine.v1.TerminalLocationB\002\030\001\022\035\n" +
      "\025current_route_segment\030\024 \001(\t\022A\n\035current_" +
      "route_segment_version\030\017 \001(\0132\032.google.pro" +
      "tobuf.Timestamp\022J\n\037current_route_segment" +
      "_end_point\030\030 \001(\0132!.maps.fleetengine.v1.T" +
      "ripWaypoint\022>\n\031remaining_distance_meters" +
      "\030\022 \001(\0132\033.google.protobuf.Int32Value\0229\n\025e" +
      "ta_to_first_waypoint\030\023 \001(\0132\032.google.prot" +
      "obuf.Timestamp\022;\n\026remaining_time_seconds" +
      "\030\031 \001(\0132\033.google.protobuf.Int32Value\0224\n\tw" +
      "aypoints\030\026 \003(\0132!.maps.fleetengine.v1.Tri" +
      "pWaypoint\0225\n\021waypoints_version\030\020 \001(\0132\032.g" +
      "oogle.protobuf.Timestamp\022\034\n\024back_to_back" +
      "_enabled\030\027 \001(\010\022@\n\021navigation_status\030\032 \001(" +
      "\0162%.maps.fleetengine.v1.NavigationStatus" +
      "\022<\n\017device_settings\030\033 \001(\0132#.maps.fleeten" +
      "gine.v1.DeviceSettings\032\233\001\n\013VehicleType\022C" +
      "\n\010category\030\001 \001(\01621.maps.fleetengine.v1.V" +
      "ehicle.VehicleType.Category\"G\n\010Category\022" +
      "\013\n\007UNKNOWN\020\000\022\010\n\004AUTO\020\001\022\010\n\004TAXI\020\002\022\t\n\005TRUC" +
      "K\020\003\022\017\n\013TWO_WHEELER\020\004:P\352AM\n\"fleetengine.g" +
      "oogleapis.com/Vehicle\022\'providers/{provid" +
      "er}/vehicles/{vehicle}\"\235\001\n\013BatteryInfo\022:" +
      "\n\016battery_status\030\001 \001(\0162\".maps.fleetengin" +
      "e.v1.BatteryStatus\0226\n\014power_source\030\002 \001(\016" +
      "2 .maps.fleetengine.v1.PowerSource\022\032\n\022ba" +
      "ttery_percentage\030\003 \001(\002\"\312\001\n\016DeviceSetting" +
      "s\022L\n\030location_power_save_mode\030\001 \001(\0162*.ma" +
      "ps.fleetengine.v1.LocationPowerSaveMode\022" +
      "\032\n\022is_power_save_mode\030\002 \001(\010\022\026\n\016is_intera" +
      "ctive\030\003 \001(\010\0226\n\014battery_info\030\004 \001(\0132 .maps" +
      ".fleetengine.v1.BatteryInfo\"A\n\014LicensePl" +
      "ate\022\031\n\014country_code\030\001 \001(\tB\003\340A\002\022\026\n\016last_c" +
      "haracter\030\002 \001(\t*B\n\014VehicleState\022\031\n\025UNKNOW" +
      "N_VEHICLE_STATE\020\000\022\013\n\007OFFLINE\020\001\022\n\n\006ONLINE" +
      "\020\002*\222\002\n\025LocationPowerSaveMode\022$\n UNKNOWN_" +
      "LOCATION_POWER_SAVE_MODE\020\000\022\033\n\027LOCATION_M" +
      "ODE_NO_CHANGE\020\001\022.\n*LOCATION_MODE_GPS_DIS" +
      "ABLED_WHEN_SCREEN_OFF\020\002\022.\n*LOCATION_MODE" +
      "_ALL_DISABLED_WHEN_SCREEN_OFF\020\003\022!\n\035LOCAT" +
      "ION_MODE_FOREGROUND_ONLY\020\004\0223\n/LOCATION_M" +
      "ODE_THROTTLE_REQUESTS_WHEN_SCREEN_OFF\020\005*" +
      "\300\001\n\rBatteryStatus\022\032\n\026UNKNOWN_BATTERY_STA" +
      "TUS\020\000\022\033\n\027BATTERY_STATUS_CHARGING\020\001\022\036\n\032BA" +
      "TTERY_STATUS_DISCHARGING\020\002\022\027\n\023BATTERY_ST" +
      "ATUS_FULL\020\003\022\037\n\033BATTERY_STATUS_NOT_CHARGI" +
      "NG\020\004\022\034\n\030BATTERY_STATUS_POWER_LOW\020\005*\211\001\n\013P" +
      "owerSource\022\030\n\024UNKNOWN_POWER_SOURCE\020\000\022\023\n\017" +
      "POWER_SOURCE_AC\020\001\022\024\n\020POWER_SOURCE_USB\020\002\022" +
      "\031\n\025POWER_SOURCE_WIRELESS\020\003\022\032\n\026POWER_SOUR" +
      "CE_UNPLUGGED\020\004Bu\n\032google.maps.fleetengin" +
      "e.v1B\010VehiclesP\001ZEgoogle.golang.org/genp" +
      "roto/googleapis/maps/fleetengine/v1;flee" +
      "tengine\242\002\003CFEb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
          google.maps.fleetengine.v1.FleetEngine.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_maps_fleetengine_v1_Vehicle_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_maps_fleetengine_v1_Vehicle_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_maps_fleetengine_v1_Vehicle_descriptor,
        new java.lang.String[] { "Name", "VehicleState", "SupportedTripTypes", "CurrentTrips", "LastLocation", "MaximumCapacity", "AvailableCapacity", "Attributes", "VehicleType", "LicensePlate", "Route", "CurrentRouteSegment", "CurrentRouteSegmentVersion", "CurrentRouteSegmentEndPoint", "RemainingDistanceMeters", "EtaToFirstWaypoint", "RemainingTimeSeconds", "Waypoints", "WaypointsVersion", "BackToBackEnabled", "NavigationStatus", "DeviceSettings", });
    internal_static_maps_fleetengine_v1_Vehicle_VehicleType_descriptor =
      internal_static_maps_fleetengine_v1_Vehicle_descriptor.getNestedTypes().get(0);
    internal_static_maps_fleetengine_v1_Vehicle_VehicleType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_maps_fleetengine_v1_Vehicle_VehicleType_descriptor,
        new java.lang.String[] { "Category", });
    internal_static_maps_fleetengine_v1_BatteryInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_maps_fleetengine_v1_BatteryInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_maps_fleetengine_v1_BatteryInfo_descriptor,
        new java.lang.String[] { "BatteryStatus", "PowerSource", "BatteryPercentage", });
    internal_static_maps_fleetengine_v1_DeviceSettings_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_maps_fleetengine_v1_DeviceSettings_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_maps_fleetengine_v1_DeviceSettings_descriptor,
        new java.lang.String[] { "LocationPowerSaveMode", "IsPowerSaveMode", "IsInteractive", "BatteryInfo", });
    internal_static_maps_fleetengine_v1_LicensePlate_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_maps_fleetengine_v1_LicensePlate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_maps_fleetengine_v1_LicensePlate_descriptor,
        new java.lang.String[] { "CountryCode", "LastCharacter", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    google.maps.fleetengine.v1.FleetEngine.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
