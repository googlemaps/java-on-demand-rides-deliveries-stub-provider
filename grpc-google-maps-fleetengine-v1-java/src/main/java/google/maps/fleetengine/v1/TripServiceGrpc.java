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
 * Trip management service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/fleetengine/v1/trip_api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TripServiceGrpc {

  private TripServiceGrpc() {}

  public static final String SERVICE_NAME = "maps.fleetengine.v1.TripService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CreateTripRequest,
      Trip> getCreateTripMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrip",
      requestType = CreateTripRequest.class,
      responseType = Trip.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CreateTripRequest,
      Trip> getCreateTripMethod() {
    io.grpc.MethodDescriptor<CreateTripRequest, Trip> getCreateTripMethod;
    if ((getCreateTripMethod = TripServiceGrpc.getCreateTripMethod) == null) {
      synchronized (TripServiceGrpc.class) {
        if ((getCreateTripMethod = TripServiceGrpc.getCreateTripMethod) == null) {
          TripServiceGrpc.getCreateTripMethod = getCreateTripMethod =
              io.grpc.MethodDescriptor.<CreateTripRequest, Trip>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrip"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateTripRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Trip.getDefaultInstance()))
              .setSchemaDescriptor(new TripServiceMethodDescriptorSupplier("CreateTrip"))
              .build();
        }
      }
    }
    return getCreateTripMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetTripRequest,
      Trip> getGetTripMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrip",
      requestType = GetTripRequest.class,
      responseType = Trip.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetTripRequest,
      Trip> getGetTripMethod() {
    io.grpc.MethodDescriptor<GetTripRequest, Trip> getGetTripMethod;
    if ((getGetTripMethod = TripServiceGrpc.getGetTripMethod) == null) {
      synchronized (TripServiceGrpc.class) {
        if ((getGetTripMethod = TripServiceGrpc.getGetTripMethod) == null) {
          TripServiceGrpc.getGetTripMethod = getGetTripMethod =
              io.grpc.MethodDescriptor.<GetTripRequest, Trip>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrip"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetTripRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Trip.getDefaultInstance()))
              .setSchemaDescriptor(new TripServiceMethodDescriptorSupplier("GetTrip"))
              .build();
        }
      }
    }
    return getGetTripMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ReportBillableTripRequest,
      com.google.protobuf.Empty> getReportBillableTripMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportBillableTrip",
      requestType = ReportBillableTripRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ReportBillableTripRequest,
      com.google.protobuf.Empty> getReportBillableTripMethod() {
    io.grpc.MethodDescriptor<ReportBillableTripRequest, com.google.protobuf.Empty> getReportBillableTripMethod;
    if ((getReportBillableTripMethod = TripServiceGrpc.getReportBillableTripMethod) == null) {
      synchronized (TripServiceGrpc.class) {
        if ((getReportBillableTripMethod = TripServiceGrpc.getReportBillableTripMethod) == null) {
          TripServiceGrpc.getReportBillableTripMethod = getReportBillableTripMethod =
              io.grpc.MethodDescriptor.<ReportBillableTripRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportBillableTrip"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReportBillableTripRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new TripServiceMethodDescriptorSupplier("ReportBillableTrip"))
              .build();
        }
      }
    }
    return getReportBillableTripMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SearchTripsRequest,
      SearchTripsResponse> getSearchTripsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchTrips",
      requestType = SearchTripsRequest.class,
      responseType = SearchTripsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SearchTripsRequest,
      SearchTripsResponse> getSearchTripsMethod() {
    io.grpc.MethodDescriptor<SearchTripsRequest, SearchTripsResponse> getSearchTripsMethod;
    if ((getSearchTripsMethod = TripServiceGrpc.getSearchTripsMethod) == null) {
      synchronized (TripServiceGrpc.class) {
        if ((getSearchTripsMethod = TripServiceGrpc.getSearchTripsMethod) == null) {
          TripServiceGrpc.getSearchTripsMethod = getSearchTripsMethod =
              io.grpc.MethodDescriptor.<SearchTripsRequest, SearchTripsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchTrips"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchTripsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SearchTripsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TripServiceMethodDescriptorSupplier("SearchTrips"))
              .build();
        }
      }
    }
    return getSearchTripsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateTripRequest,
      Trip> getUpdateTripMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTrip",
      requestType = UpdateTripRequest.class,
      responseType = Trip.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateTripRequest,
      Trip> getUpdateTripMethod() {
    io.grpc.MethodDescriptor<UpdateTripRequest, Trip> getUpdateTripMethod;
    if ((getUpdateTripMethod = TripServiceGrpc.getUpdateTripMethod) == null) {
      synchronized (TripServiceGrpc.class) {
        if ((getUpdateTripMethod = TripServiceGrpc.getUpdateTripMethod) == null) {
          TripServiceGrpc.getUpdateTripMethod = getUpdateTripMethod =
              io.grpc.MethodDescriptor.<UpdateTripRequest, Trip>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTrip"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateTripRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Trip.getDefaultInstance()))
              .setSchemaDescriptor(new TripServiceMethodDescriptorSupplier("UpdateTrip"))
              .build();
        }
      }
    }
    return getUpdateTripMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TripServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TripServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TripServiceStub>() {
        @Override
        public TripServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TripServiceStub(channel, callOptions);
        }
      };
    return TripServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TripServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TripServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TripServiceBlockingStub>() {
        @Override
        public TripServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TripServiceBlockingStub(channel, callOptions);
        }
      };
    return TripServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TripServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TripServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TripServiceFutureStub>() {
        @Override
        public TripServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TripServiceFutureStub(channel, callOptions);
        }
      };
    return TripServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Trip management service.
   * </pre>
   */
  public static abstract class TripServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a trip in the Fleet Engine and returns the new trip.
     * </pre>
     */
    public void createTrip(CreateTripRequest request,
        io.grpc.stub.StreamObserver<Trip> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTripMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get information about a single trip.
     * </pre>
     */
    public void getTrip(GetTripRequest request,
        io.grpc.stub.StreamObserver<Trip> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTripMethod(), responseObserver);
    }

    /**
     * <pre>
     * Report billable trip usage.
     * </pre>
     */
    public void reportBillableTrip(ReportBillableTripRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReportBillableTripMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get all the trips for a specific vehicle.
     * </pre>
     */
    public void searchTrips(SearchTripsRequest request,
        io.grpc.stub.StreamObserver<SearchTripsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchTripsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates trip data.
     * </pre>
     */
    public void updateTrip(UpdateTripRequest request,
        io.grpc.stub.StreamObserver<Trip> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTripMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTripMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                CreateTripRequest,
                Trip>(
                  this, METHODID_CREATE_TRIP)))
          .addMethod(
            getGetTripMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetTripRequest,
                Trip>(
                  this, METHODID_GET_TRIP)))
          .addMethod(
            getReportBillableTripMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ReportBillableTripRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_REPORT_BILLABLE_TRIP)))
          .addMethod(
            getSearchTripsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SearchTripsRequest,
                SearchTripsResponse>(
                  this, METHODID_SEARCH_TRIPS)))
          .addMethod(
            getUpdateTripMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                UpdateTripRequest,
                Trip>(
                  this, METHODID_UPDATE_TRIP)))
          .build();
    }
  }

  /**
   * <pre>
   * Trip management service.
   * </pre>
   */
  public static final class TripServiceStub extends io.grpc.stub.AbstractAsyncStub<TripServiceStub> {
    private TripServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TripServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TripServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a trip in the Fleet Engine and returns the new trip.
     * </pre>
     */
    public void createTrip(CreateTripRequest request,
        io.grpc.stub.StreamObserver<Trip> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTripMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get information about a single trip.
     * </pre>
     */
    public void getTrip(GetTripRequest request,
        io.grpc.stub.StreamObserver<Trip> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTripMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Report billable trip usage.
     * </pre>
     */
    public void reportBillableTrip(ReportBillableTripRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportBillableTripMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get all the trips for a specific vehicle.
     * </pre>
     */
    public void searchTrips(SearchTripsRequest request,
        io.grpc.stub.StreamObserver<SearchTripsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchTripsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates trip data.
     * </pre>
     */
    public void updateTrip(UpdateTripRequest request,
        io.grpc.stub.StreamObserver<Trip> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTripMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Trip management service.
   * </pre>
   */
  public static final class TripServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TripServiceBlockingStub> {
    private TripServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TripServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TripServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a trip in the Fleet Engine and returns the new trip.
     * </pre>
     */
    public Trip createTrip(CreateTripRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTripMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get information about a single trip.
     * </pre>
     */
    public Trip getTrip(GetTripRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTripMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Report billable trip usage.
     * </pre>
     */
    public com.google.protobuf.Empty reportBillableTrip(ReportBillableTripRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportBillableTripMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get all the trips for a specific vehicle.
     * </pre>
     */
    public SearchTripsResponse searchTrips(SearchTripsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchTripsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates trip data.
     * </pre>
     */
    public Trip updateTrip(UpdateTripRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTripMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Trip management service.
   * </pre>
   */
  public static final class TripServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TripServiceFutureStub> {
    private TripServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TripServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TripServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a trip in the Fleet Engine and returns the new trip.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Trip> createTrip(
        CreateTripRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTripMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get information about a single trip.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Trip> getTrip(
        GetTripRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTripMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Report billable trip usage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> reportBillableTrip(
        ReportBillableTripRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportBillableTripMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get all the trips for a specific vehicle.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<SearchTripsResponse> searchTrips(
        SearchTripsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchTripsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates trip data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Trip> updateTrip(
        UpdateTripRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTripMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TRIP = 0;
  private static final int METHODID_GET_TRIP = 1;
  private static final int METHODID_REPORT_BILLABLE_TRIP = 2;
  private static final int METHODID_SEARCH_TRIPS = 3;
  private static final int METHODID_UPDATE_TRIP = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TripServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TripServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TRIP:
          serviceImpl.createTrip((CreateTripRequest) request,
              (io.grpc.stub.StreamObserver<Trip>) responseObserver);
          break;
        case METHODID_GET_TRIP:
          serviceImpl.getTrip((GetTripRequest) request,
              (io.grpc.stub.StreamObserver<Trip>) responseObserver);
          break;
        case METHODID_REPORT_BILLABLE_TRIP:
          serviceImpl.reportBillableTrip((ReportBillableTripRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_TRIPS:
          serviceImpl.searchTrips((SearchTripsRequest) request,
              (io.grpc.stub.StreamObserver<SearchTripsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TRIP:
          serviceImpl.updateTrip((UpdateTripRequest) request,
              (io.grpc.stub.StreamObserver<Trip>) responseObserver);
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

  private static abstract class TripServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TripServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return TripApi.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TripService");
    }
  }

  private static final class TripServiceFileDescriptorSupplier
      extends TripServiceBaseDescriptorSupplier {
    TripServiceFileDescriptorSupplier() {}
  }

  private static final class TripServiceMethodDescriptorSupplier
      extends TripServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TripServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TripServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TripServiceFileDescriptorSupplier())
              .addMethod(getCreateTripMethod())
              .addMethod(getGetTripMethod())
              .addMethod(getReportBillableTripMethod())
              .addMethod(getSearchTripsMethod())
              .addMethod(getUpdateTripMethod())
              .build();
        }
      }
    }
    return result;
  }
}
