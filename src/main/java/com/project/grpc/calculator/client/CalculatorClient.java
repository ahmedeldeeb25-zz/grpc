package com.project.grpc.calculator.client;

import com.proto.calculator.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class CalculatorClient {

    public static void main(String[] args) {

        System.out.println("Hello I'm  gRPC client");

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        System.out.println("Calculator stub");
        calculatorServiceGrpc.calculatorServiceBlockingStub stub =
                calculatorServiceGrpc.newBlockingStub(channel);
        // Unary streaming
        /*
        SumRequest sumRequest = SumRequest.newBuilder()
                .setFirstNumber(10)
                .setSecondNumber(24)
                .build();

        SumResponse sumResponse = stub.sum(sumRequest);

        System.out.println(sumRequest.getFirstNumber() + " + " + sumRequest.getSecondNumber() + " = " + sumResponse.getSumResult());
         */
        try {
            squareRootResponse squareResponse = stub.squareRoot(squareRootRequest.newBuilder().setValue(9).build());
            System.out.println("The value is "+squareResponse.getResult());
        } catch (StatusRuntimeException e) {
            System.out.println("Excpetion appeared");
            e.printStackTrace();
        }
        channel.shutdown();
    }
}
