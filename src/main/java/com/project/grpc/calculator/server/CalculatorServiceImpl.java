package com.project.grpc.calculator.server;

import com.proto.calculator.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends calculatorServiceGrpc.calculatorServiceImplBase {

    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        SumResponse sumResponse = SumResponse.newBuilder()
                .setSumResult(request.getFirstNumber() + request.getSecondNumber())
                .build();

        responseObserver.onNext(sumResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void squareRoot(squareRootRequest request, StreamObserver<squareRootResponse> responseObserver) {
        Integer number = request.getValue();

        if (number > 0) {
            double numberRoot = Math.sqrt(number);
            System.out.println("Square Root ="+numberRoot);
            responseObserver.onNext(
                    squareRootResponse.newBuilder().setResult(numberRoot).build()
            );
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("Number should be an Integer >= 0")
                            .augmentDescription("Number = " + number)
                            .asRuntimeException()
            );
        }
    }
}
