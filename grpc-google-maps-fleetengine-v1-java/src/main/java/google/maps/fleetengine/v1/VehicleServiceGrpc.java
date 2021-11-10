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
package google.maps.fleetengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Vehicle management service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/fleetengine/v1/vehicle_api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VehicleServiceGrpc {

  private VehicleServiceGrpc() {}

  public static final String SERVICE_NAME = "maps.fleetengine.v1.VehicleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CreateVehicleRequest,
      Vehicle> getCreateVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVehicle",
      requestType = CreateVehicleRequest.class,
      responseType = Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CreateVehicleRequest,
      Vehicle> getCreateVehicleMethod() {
    io.grpc.MethodDescriptor<CreateVehicleRequest, Vehicle> getCreateVehicleMethod;
    if ((getCreateVehicleMethod = VehicleServiceGrpc.getCreateVehicleMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getCreateVehicleMethod = VehicleServiceGrpc.getCreateVehicleMethod) == null) {
          VehicleServiceGrpc.getCreateVehicleMethod = getCreateVehicleMethod =
              io.grpc.MethodDescriptor.<CreateVehicleRequest, Vehicle>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVehicle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Vehicle.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("CreateVehicle"))
              .build();
        }
      }
    }
    return getCreateVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetVehicleRequest,
      Vehicle> getGetVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVehicle",
      requestType = GetVehicleRequest.class,
      responseType = Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetVehicleRequest,
      Vehicle> getGetVehicleMethod() {
    io.grpc.MethodDescriptor<GetVehicleRequest, Vehicle> getGetVehicleMethod;
    if ((getGetVehicleMethod = VehicleServiceGrpc.getGetVehicleMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getGetVehicleMethod = VehicleServiceGrpc.getGetVehicleMethod) == null) {
          VehicleServiceGrpc.getGetVehicleMethod = getGetVehicleMethod =
              io.grpc.MethodDescriptor.<GetVehicleRequest, Vehicle>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVehicle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Vehicle.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("GetVehicle"))
              .build();
        }
      }
    }
    return getGetVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateVehicleRequest,
      Vehicle> getUpdateVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVehicle",
      requestType = UpdateVehicleRequest.class,
      responseType = Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateVehicleRequest,
      Vehicle> getUpdateVehicleMethod() {
    io.grpc.MethodDescriptor<UpdateVehicleRequest, Vehicle> getUpdateVehicleMethod;
    if ((getUpdateVehicleMethod = VehicleServiceGrpc.getUpdateVehicleMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getUpdateVehicleMethod = VehicleServiceGrpc.getUpdateVehicleMethod) == null) {
          VehicleServiceGrpc.getUpdateVehicleMethod = getUpdateVehicleMethod =
              io.grpc.MethodDescriptor.<UpdateVehicleRequest, Vehicle>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVehicle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Vehicle.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("UpdateVehicle"))
              .build();
        }
      }
    }
    return getUpdateVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateVehicleLocationRequest,
      VehicleLocation> getUpdateVehicleLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVehicleLocation",
      requestType = UpdateVehicleLocationRequest.class,
      responseType = VehicleLocation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateVehicleLocationRequest,
      VehicleLocation> getUpdateVehicleLocationMethod() {
    io.grpc.MethodDescriptor<UpdateVehicleLocationRequest, VehicleLocation> getUpdateVehicleLocationMethod;
    if ((getUpdateVehicleLocationMethod = VehicleServiceGrpc.getUpdateVehicleLocationMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getUpdateVehicleLocationMethod = VehicleServiceGrpc.getUpdateVehicleLocationMethod) == null) {
          VehicleServiceGrpc.getUpdateVehicleLocationMethod = getUpdateVehicleLocationMethod =
              io.grpc.MethodDescriptor.<UpdateVehicleLocationRequest, VehicleLocation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVehicleLocation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateVehicleLocationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  VehicleLocation.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("UpdateVehicleLocation"))
              .build();
        }
      }
    }
    return getUpdateVehicleLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateVehicleAttributesRequest,
      UpdateVehicleAttributesResponse> getUpdateVehicleAttributesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVehicleAttributes",
      requestType = UpdateVehicleAttributesRequest.class,
      responseType = UpdateVehicleAttributesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateVehicleAttributesRequest,
      UpdateVehicleAttributesResponse> getUpdateVehicleAttributesMethod() {
    io.grpc.MethodDescriptor<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse> getUpdateVehicleAttributesMethod;
    if ((getUpdateVehicleAttributesMethod = VehicleServiceGrpc.getUpdateVehicleAttributesMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getUpdateVehicleAttributesMethod = VehicleServiceGrpc.getUpdateVehicleAttributesMethod) == null) {
          VehicleServiceGrpc.getUpdateVehicleAttributesMethod = getUpdateVehicleAttributesMethod =
              io.grpc.MethodDescriptor.<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVehicleAttributes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateVehicleAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateVehicleAttributesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("UpdateVehicleAttributes"))
              .build();
        }
      }
    }
    return getUpdateVehicleAttributesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ListVehiclesRequest,
      ListVehiclesResponse> getListVehiclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVehicles",
      requestType = ListVehiclesRequest.class,
      responseType = ListVehiclesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ListVehiclesRequest,
      ListVehiclesResponse> getListVehiclesMethod() {
    io.grpc.MethodDescriptor<ListVehiclesRequest, ListVehiclesResponse> getListVehiclesMethod;
    if ((getListVehiclesMethod = VehicleServiceGrpc.getListVehiclesMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getListVehiclesMethod = VehicleServiceGrpc.getListVehiclesMethod) == null) {
          VehicleServiceGrpc.getListVehiclesMethod = getListVehiclesMethod =
              io.grpc.MethodDescriptor.<ListVehiclesRequest, ListVehiclesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVehicles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ListVehiclesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ListVehiclesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("ListVehicles"))
              .build();
        }
      }
    }
    return getListVehiclesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SearchVehiclesRequest,
      SearchVehiclesResponse> getSearchVehiclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchVehicles",
      requestType = SearchVehiclesRequest.class,
      responseType = SearchVehiclesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SearchVehiclesRequest,
      SearchVehiclesResponse> getSearchVehiclesMethod() {
    io.grpc.MethodDescriptor<SearchVehiclesRequest, SearchVehiclesResponse> getSearchVehiclesMethod;
    if ((getSearchVehiclesMethod = VehicleServiceGrpc.getSearchVehiclesMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getSearchVehiclesMethod = VehicleServiceGrpc.getSearchVehiclesMethod) == null) {
          VehicleServiceGrpc.getSearchVehiclesMethod = getSearchVehiclesMethod =
              io.grpc.MethodDescriptor.<SearchVehiclesRequest, SearchVehiclesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchVehicles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchVehiclesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchVehiclesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("SearchVehicles"))
              .build();
        }
      }
    }
    return getSearchVehiclesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SearchVehiclesRequest,
      SearchVehiclesResponse> getSearchFuzzedVehiclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchFuzzedVehicles",
      requestType = SearchVehiclesRequest.class,
      responseType = SearchVehiclesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SearchVehiclesRequest,
      SearchVehiclesResponse> getSearchFuzzedVehiclesMethod() {
    io.grpc.MethodDescriptor<SearchVehiclesRequest, SearchVehiclesResponse> getSearchFuzzedVehiclesMethod;
    if ((getSearchFuzzedVehiclesMethod = VehicleServiceGrpc.getSearchFuzzedVehiclesMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getSearchFuzzedVehiclesMethod = VehicleServiceGrpc.getSearchFuzzedVehiclesMethod) == null) {
          VehicleServiceGrpc.getSearchFuzzedVehiclesMethod = getSearchFuzzedVehiclesMethod =
              io.grpc.MethodDescriptor.<SearchVehiclesRequest, SearchVehiclesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchFuzzedVehicles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchVehiclesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchVehiclesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("SearchFuzzedVehicles"))
              .build();
        }
      }
    }
    return getSearchFuzzedVehiclesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VehicleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VehicleServiceStub>() {
        @Override
        public VehicleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VehicleServiceStub(channel, callOptions);
        }
      };
    return VehicleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VehicleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VehicleServiceBlockingStub>() {
        @Override
        public VehicleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VehicleServiceBlockingStub(channel, callOptions);
        }
      };
    return VehicleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VehicleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VehicleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VehicleServiceFutureStub>() {
        @Override
        public VehicleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VehicleServiceFutureStub(channel, callOptions);
        }
      };
    return VehicleServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public static abstract class VehicleServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreateVehicle instantiates a new vehicle associated with a rideshare
     * provider in the Fleet Engine. Vehicles must have a unique vehicle ID.
     * The following Vehicle fields are required when creating a Vehicle:
     * * vehicleState
     * * supportedTripTypes
     * * maximumCapacity
     * * vehicleType
     * The following Vehicle fields are ignored when creating a Vehicle:
     * * name
     * * currentTrips
     * * availableCapacity
     * * current_route_segment
     * * current_route_segment_version
     * * waypoint
     * * waypoints_version
     * * remaining_distance_meters
     * * eta_to_next_waypoint
     * * navigation_status
     * All other fields are optional and used if provided.
     * </pre>
     */
    public void createVehicle(CreateVehicleRequest request,
        io.grpc.stub.StreamObserver<Vehicle> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateVehicleMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetVehicle returns a vehicle from the Fleet Engine.
     * </pre>
     */
    public void getVehicle(GetVehicleRequest request,
        io.grpc.stub.StreamObserver<Vehicle> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVehicleMethod(), responseObserver);
    }

    /**
     * <pre>
     * UpdateVehicle writes updated vehicle data to the Fleet Engine.
     * When updating a Vehicle, the following fields cannot be updated since they
     * are managed by the Fleet Engine:
     * * currentTrips
     * * availableCapacity
     * * current_route_segment_version
     * * waypoints_version
     * The vehicle name also cannot be updated.
     * The waypoints field can be updated, but must contain all the waypoints
     * currently on the vehicle, and no other waypoints.
     * </pre>
     */
    public void updateVehicle(UpdateVehicleRequest request,
        io.grpc.stub.StreamObserver<Vehicle> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVehicleMethod(), responseObserver);
    }

    /**
     * <pre>
     * UpdateVehicleLocation updates the location of the vehicle.
     * This method is deprecated. Use UpdateVehicle method instead.
     * </pre>
     */
    @Deprecated
    public void updateVehicleLocation(UpdateVehicleLocationRequest request,
        io.grpc.stub.StreamObserver<VehicleLocation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVehicleLocationMethod(), responseObserver);
    }

    /**
     * <pre>
     * UpdateVehicleAttributes partially updates a vehicle's attributes.
     * Only the attributes mentioned in the request will be updated, other
     * attributes will NOT be altered. Note: this is different in UpdateVehicle,
     * where the whole `attributes` field will be replaced by the one in
     * UpdateVehicleRequest, attributes not in the request would be removed.
     * </pre>
     */
    public void updateVehicleAttributes(UpdateVehicleAttributesRequest request,
        io.grpc.stub.StreamObserver<UpdateVehicleAttributesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVehicleAttributesMethod(), responseObserver);
    }

    /**
     * <pre>
     * ListVehicles returns a paginated list of vehicles associated with
     * a provider that match the request options.
     * </pre>
     */
    public void listVehicles(ListVehiclesRequest request,
        io.grpc.stub.StreamObserver<ListVehiclesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListVehiclesMethod(), responseObserver);
    }

    /**
     * <pre>
     * SearchVehicles returns a list of vehicles that match the request options.
     * </pre>
     */
    public void searchVehicles(SearchVehiclesRequest request,
        io.grpc.stub.StreamObserver<SearchVehiclesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchVehiclesMethod(), responseObserver);
    }

    /**
     * <pre>
     * SearchFuzzedVehicles returns a list of vehicles that match the request
     * options with their locations fuzzed.
     * Request does not support 'order_by' field.
     * Vehicle matches in response will be in order of distance from pickup point.
     * Vehicle matches in response will only have 'vehicle' and 'trip_type' field
     * set.
     * </pre>
     */
    public void searchFuzzedVehicles(SearchVehiclesRequest request,
        io.grpc.stub.StreamObserver<SearchVehiclesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchFuzzedVehiclesMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                CreateVehicleRequest,
                Vehicle>(
                  this, METHODID_CREATE_VEHICLE)))
          .addMethod(
            getGetVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetVehicleRequest,
                Vehicle>(
                  this, METHODID_GET_VEHICLE)))
          .addMethod(
            getUpdateVehicleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                UpdateVehicleRequest,
                Vehicle>(
                  this, METHODID_UPDATE_VEHICLE)))
          .addMethod(
            getUpdateVehicleLocationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                UpdateVehicleLocationRequest,
                VehicleLocation>(
                  this, METHODID_UPDATE_VEHICLE_LOCATION)))
          .addMethod(
            getUpdateVehicleAttributesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                UpdateVehicleAttributesRequest,
                UpdateVehicleAttributesResponse>(
                  this, METHODID_UPDATE_VEHICLE_ATTRIBUTES)))
          .addMethod(
            getListVehiclesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ListVehiclesRequest,
                ListVehiclesResponse>(
                  this, METHODID_LIST_VEHICLES)))
          .addMethod(
            getSearchVehiclesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SearchVehiclesRequest,
                SearchVehiclesResponse>(
                  this, METHODID_SEARCH_VEHICLES)))
          .addMethod(
            getSearchFuzzedVehiclesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SearchVehiclesRequest,
                SearchVehiclesResponse>(
                  this, METHODID_SEARCH_FUZZED_VEHICLES)))
          .build();
    }
  }

  /**
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public static final class VehicleServiceStub extends io.grpc.stub.AbstractAsyncStub<VehicleServiceStub> {
    private VehicleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected VehicleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateVehicle instantiates a new vehicle associated with a rideshare
     * provider in the Fleet Engine. Vehicles must have a unique vehicle ID.
     * The following Vehicle fields are required when creating a Vehicle:
     * * vehicleState
     * * supportedTripTypes
     * * maximumCapacity
     * * vehicleType
     * The following Vehicle fields are ignored when creating a Vehicle:
     * * name
     * * currentTrips
     * * availableCapacity
     * * current_route_segment
     * * current_route_segment_version
     * * waypoint
     * * waypoints_version
     * * remaining_distance_meters
     * * eta_to_next_waypoint
     * * navigation_status
     * All other fields are optional and used if provided.
     * </pre>
     */
    public void createVehicle(CreateVehicleRequest request,
        io.grpc.stub.StreamObserver<Vehicle> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVehicleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetVehicle returns a vehicle from the Fleet Engine.
     * </pre>
     */
    public void getVehicle(GetVehicleRequest request,
        io.grpc.stub.StreamObserver<Vehicle> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVehicleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UpdateVehicle writes updated vehicle data to the Fleet Engine.
     * When updating a Vehicle, the following fields cannot be updated since they
     * are managed by the Fleet Engine:
     * * currentTrips
     * * availableCapacity
     * * current_route_segment_version
     * * waypoints_version
     * The vehicle name also cannot be updated.
     * The waypoints field can be updated, but must contain all the waypoints
     * currently on the vehicle, and no other waypoints.
     * </pre>
     */
    public void updateVehicle(UpdateVehicleRequest request,
        io.grpc.stub.StreamObserver<Vehicle> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVehicleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UpdateVehicleLocation updates the location of the vehicle.
     * This method is deprecated. Use UpdateVehicle method instead.
     * </pre>
     */
    @Deprecated
    public void updateVehicleLocation(UpdateVehicleLocationRequest request,
        io.grpc.stub.StreamObserver<VehicleLocation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVehicleLocationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UpdateVehicleAttributes partially updates a vehicle's attributes.
     * Only the attributes mentioned in the request will be updated, other
     * attributes will NOT be altered. Note: this is different in UpdateVehicle,
     * where the whole `attributes` field will be replaced by the one in
     * UpdateVehicleRequest, attributes not in the request would be removed.
     * </pre>
     */
    public void updateVehicleAttributes(UpdateVehicleAttributesRequest request,
        io.grpc.stub.StreamObserver<UpdateVehicleAttributesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVehicleAttributesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ListVehicles returns a paginated list of vehicles associated with
     * a provider that match the request options.
     * </pre>
     */
    public void listVehicles(ListVehiclesRequest request,
        io.grpc.stub.StreamObserver<ListVehiclesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVehiclesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * SearchVehicles returns a list of vehicles that match the request options.
     * </pre>
     */
    public void searchVehicles(SearchVehiclesRequest request,
        io.grpc.stub.StreamObserver<SearchVehiclesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchVehiclesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * SearchFuzzedVehicles returns a list of vehicles that match the request
     * options with their locations fuzzed.
     * Request does not support 'order_by' field.
     * Vehicle matches in response will be in order of distance from pickup point.
     * Vehicle matches in response will only have 'vehicle' and 'trip_type' field
     * set.
     * </pre>
     */
    public void searchFuzzedVehicles(SearchVehiclesRequest request,
        io.grpc.stub.StreamObserver<SearchVehiclesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchFuzzedVehiclesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public static final class VehicleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<VehicleServiceBlockingStub> {
    private VehicleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected VehicleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateVehicle instantiates a new vehicle associated with a rideshare
     * provider in the Fleet Engine. Vehicles must have a unique vehicle ID.
     * The following Vehicle fields are required when creating a Vehicle:
     * * vehicleState
     * * supportedTripTypes
     * * maximumCapacity
     * * vehicleType
     * The following Vehicle fields are ignored when creating a Vehicle:
     * * name
     * * currentTrips
     * * availableCapacity
     * * current_route_segment
     * * current_route_segment_version
     * * waypoint
     * * waypoints_version
     * * remaining_distance_meters
     * * eta_to_next_waypoint
     * * navigation_status
     * All other fields are optional and used if provided.
     * </pre>
     */
    public Vehicle createVehicle(CreateVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVehicleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetVehicle returns a vehicle from the Fleet Engine.
     * </pre>
     */
    public Vehicle getVehicle(GetVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVehicleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * UpdateVehicle writes updated vehicle data to the Fleet Engine.
     * When updating a Vehicle, the following fields cannot be updated since they
     * are managed by the Fleet Engine:
     * * currentTrips
     * * availableCapacity
     * * current_route_segment_version
     * * waypoints_version
     * The vehicle name also cannot be updated.
     * The waypoints field can be updated, but must contain all the waypoints
     * currently on the vehicle, and no other waypoints.
     * </pre>
     */
    public Vehicle updateVehicle(UpdateVehicleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVehicleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * UpdateVehicleLocation updates the location of the vehicle.
     * This method is deprecated. Use UpdateVehicle method instead.
     * </pre>
     */
    @Deprecated
    public VehicleLocation updateVehicleLocation(UpdateVehicleLocationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVehicleLocationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * UpdateVehicleAttributes partially updates a vehicle's attributes.
     * Only the attributes mentioned in the request will be updated, other
     * attributes will NOT be altered. Note: this is different in UpdateVehicle,
     * where the whole `attributes` field will be replaced by the one in
     * UpdateVehicleRequest, attributes not in the request would be removed.
     * </pre>
     */
    public UpdateVehicleAttributesResponse updateVehicleAttributes(UpdateVehicleAttributesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVehicleAttributesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ListVehicles returns a paginated list of vehicles associated with
     * a provider that match the request options.
     * </pre>
     */
    public ListVehiclesResponse listVehicles(ListVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVehiclesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * SearchVehicles returns a list of vehicles that match the request options.
     * </pre>
     */
    public SearchVehiclesResponse searchVehicles(SearchVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchVehiclesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * SearchFuzzedVehicles returns a list of vehicles that match the request
     * options with their locations fuzzed.
     * Request does not support 'order_by' field.
     * Vehicle matches in response will be in order of distance from pickup point.
     * Vehicle matches in response will only have 'vehicle' and 'trip_type' field
     * set.
     * </pre>
     */
    public SearchVehiclesResponse searchFuzzedVehicles(SearchVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchFuzzedVehiclesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Vehicle management service.
   * </pre>
   */
  public static final class VehicleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<VehicleServiceFutureStub> {
    private VehicleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected VehicleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VehicleServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateVehicle instantiates a new vehicle associated with a rideshare
     * provider in the Fleet Engine. Vehicles must have a unique vehicle ID.
     * The following Vehicle fields are required when creating a Vehicle:
     * * vehicleState
     * * supportedTripTypes
     * * maximumCapacity
     * * vehicleType
     * The following Vehicle fields are ignored when creating a Vehicle:
     * * name
     * * currentTrips
     * * availableCapacity
     * * current_route_segment
     * * current_route_segment_version
     * * waypoint
     * * waypoints_version
     * * remaining_distance_meters
     * * eta_to_next_waypoint
     * * navigation_status
     * All other fields are optional and used if provided.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Vehicle> createVehicle(
        CreateVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVehicleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetVehicle returns a vehicle from the Fleet Engine.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Vehicle> getVehicle(
        GetVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVehicleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * UpdateVehicle writes updated vehicle data to the Fleet Engine.
     * When updating a Vehicle, the following fields cannot be updated since they
     * are managed by the Fleet Engine:
     * * currentTrips
     * * availableCapacity
     * * current_route_segment_version
     * * waypoints_version
     * The vehicle name also cannot be updated.
     * The waypoints field can be updated, but must contain all the waypoints
     * currently on the vehicle, and no other waypoints.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Vehicle> updateVehicle(
        UpdateVehicleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVehicleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * UpdateVehicleLocation updates the location of the vehicle.
     * This method is deprecated. Use UpdateVehicle method instead.
     * </pre>
     */
    @Deprecated
    public com.google.common.util.concurrent.ListenableFuture<VehicleLocation> updateVehicleLocation(
        UpdateVehicleLocationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVehicleLocationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * UpdateVehicleAttributes partially updates a vehicle's attributes.
     * Only the attributes mentioned in the request will be updated, other
     * attributes will NOT be altered. Note: this is different in UpdateVehicle,
     * where the whole `attributes` field will be replaced by the one in
     * UpdateVehicleRequest, attributes not in the request would be removed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<UpdateVehicleAttributesResponse> updateVehicleAttributes(
        UpdateVehicleAttributesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVehicleAttributesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ListVehicles returns a paginated list of vehicles associated with
     * a provider that match the request options.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ListVehiclesResponse> listVehicles(
        ListVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVehiclesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * SearchVehicles returns a list of vehicles that match the request options.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<SearchVehiclesResponse> searchVehicles(
        SearchVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchVehiclesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * SearchFuzzedVehicles returns a list of vehicles that match the request
     * options with their locations fuzzed.
     * Request does not support 'order_by' field.
     * Vehicle matches in response will be in order of distance from pickup point.
     * Vehicle matches in response will only have 'vehicle' and 'trip_type' field
     * set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<SearchVehiclesResponse> searchFuzzedVehicles(
        SearchVehiclesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchFuzzedVehiclesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_VEHICLE = 0;
  private static final int METHODID_GET_VEHICLE = 1;
  private static final int METHODID_UPDATE_VEHICLE = 2;
  private static final int METHODID_UPDATE_VEHICLE_LOCATION = 3;
  private static final int METHODID_UPDATE_VEHICLE_ATTRIBUTES = 4;
  private static final int METHODID_LIST_VEHICLES = 5;
  private static final int METHODID_SEARCH_VEHICLES = 6;
  private static final int METHODID_SEARCH_FUZZED_VEHICLES = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VehicleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VehicleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_VEHICLE:
          serviceImpl.createVehicle((CreateVehicleRequest) request,
              (io.grpc.stub.StreamObserver<Vehicle>) responseObserver);
          break;
        case METHODID_GET_VEHICLE:
          serviceImpl.getVehicle((GetVehicleRequest) request,
              (io.grpc.stub.StreamObserver<Vehicle>) responseObserver);
          break;
        case METHODID_UPDATE_VEHICLE:
          serviceImpl.updateVehicle((UpdateVehicleRequest) request,
              (io.grpc.stub.StreamObserver<Vehicle>) responseObserver);
          break;
        case METHODID_UPDATE_VEHICLE_LOCATION:
          serviceImpl.updateVehicleLocation((UpdateVehicleLocationRequest) request,
              (io.grpc.stub.StreamObserver<VehicleLocation>) responseObserver);
          break;
        case METHODID_UPDATE_VEHICLE_ATTRIBUTES:
          serviceImpl.updateVehicleAttributes((UpdateVehicleAttributesRequest) request,
              (io.grpc.stub.StreamObserver<UpdateVehicleAttributesResponse>) responseObserver);
          break;
        case METHODID_LIST_VEHICLES:
          serviceImpl.listVehicles((ListVehiclesRequest) request,
              (io.grpc.stub.StreamObserver<ListVehiclesResponse>) responseObserver);
          break;
        case METHODID_SEARCH_VEHICLES:
          serviceImpl.searchVehicles((SearchVehiclesRequest) request,
              (io.grpc.stub.StreamObserver<SearchVehiclesResponse>) responseObserver);
          break;
        case METHODID_SEARCH_FUZZED_VEHICLES:
          serviceImpl.searchFuzzedVehicles((SearchVehiclesRequest) request,
              (io.grpc.stub.StreamObserver<SearchVehiclesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class VehicleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VehicleServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return VehicleApi.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VehicleService");
    }
  }

  private static final class VehicleServiceFileDescriptorSupplier
      extends VehicleServiceBaseDescriptorSupplier {
    VehicleServiceFileDescriptorSupplier() {}
  }

  private static final class VehicleServiceMethodDescriptorSupplier
      extends VehicleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VehicleServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (VehicleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VehicleServiceFileDescriptorSupplier())
              .addMethod(getCreateVehicleMethod())
              .addMethod(getGetVehicleMethod())
              .addMethod(getUpdateVehicleMethod())
              .addMethod(getUpdateVehicleLocationMethod())
              .addMethod(getUpdateVehicleAttributesMethod())
              .addMethod(getListVehiclesMethod())
              .addMethod(getSearchVehiclesMethod())
              .addMethod(getSearchFuzzedVehiclesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
