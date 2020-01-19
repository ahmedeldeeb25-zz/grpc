package com.proto.calculator;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: calculator/calc.proto")
public final class calculatorServiceGrpc {

  private calculatorServiceGrpc() {}

  public static final String SERVICE_NAME = "greet.calculatorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.SumRequest,
      com.proto.calculator.SumResponse> getSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Sum",
      requestType = com.proto.calculator.SumRequest.class,
      responseType = com.proto.calculator.SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.calculator.SumRequest,
      com.proto.calculator.SumResponse> getSumMethod() {
    io.grpc.MethodDescriptor<com.proto.calculator.SumRequest, com.proto.calculator.SumResponse> getSumMethod;
    if ((getSumMethod = calculatorServiceGrpc.getSumMethod) == null) {
      synchronized (calculatorServiceGrpc.class) {
        if ((getSumMethod = calculatorServiceGrpc.getSumMethod) == null) {
          calculatorServiceGrpc.getSumMethod = getSumMethod =
              io.grpc.MethodDescriptor.<com.proto.calculator.SumRequest, com.proto.calculator.SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Sum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new calculatorServiceMethodDescriptorSupplier("Sum"))
              .build();
        }
      }
    }
    return getSumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static calculatorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<calculatorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<calculatorServiceStub>() {
        @java.lang.Override
        public calculatorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new calculatorServiceStub(channel, callOptions);
        }
      };
    return calculatorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static calculatorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<calculatorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<calculatorServiceBlockingStub>() {
        @java.lang.Override
        public calculatorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new calculatorServiceBlockingStub(channel, callOptions);
        }
      };
    return calculatorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static calculatorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<calculatorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<calculatorServiceFutureStub>() {
        @java.lang.Override
        public calculatorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new calculatorServiceFutureStub(channel, callOptions);
        }
      };
    return calculatorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class calculatorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sum(com.proto.calculator.SumRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.calculator.SumRequest,
                com.proto.calculator.SumResponse>(
                  this, METHODID_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class calculatorServiceStub extends io.grpc.stub.AbstractAsyncStub<calculatorServiceStub> {
    private calculatorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected calculatorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new calculatorServiceStub(channel, callOptions);
    }

    /**
     */
    public void sum(com.proto.calculator.SumRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SumResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class calculatorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<calculatorServiceBlockingStub> {
    private calculatorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected calculatorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new calculatorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.calculator.SumResponse sum(com.proto.calculator.SumRequest request) {
      return blockingUnaryCall(
          getChannel(), getSumMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class calculatorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<calculatorServiceFutureStub> {
    private calculatorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected calculatorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new calculatorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.calculator.SumResponse> sum(
        com.proto.calculator.SumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final calculatorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(calculatorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUM:
          serviceImpl.sum((com.proto.calculator.SumRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.SumResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class calculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    calculatorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.calculator.Calc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("calculatorService");
    }
  }

  private static final class calculatorServiceFileDescriptorSupplier
      extends calculatorServiceBaseDescriptorSupplier {
    calculatorServiceFileDescriptorSupplier() {}
  }

  private static final class calculatorServiceMethodDescriptorSupplier
      extends calculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    calculatorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (calculatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new calculatorServiceFileDescriptorSupplier())
              .addMethod(getSumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
