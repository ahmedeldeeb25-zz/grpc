package com.project.grpc.calculator.client;

import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import com.proto.calculator.calculatorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {

    public static void main(String[] args) {

        System.out.println("Hello I'm  gRPC client");

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",50052)
                .usePlaintext()
                .build();

        System.out.println("Calculator stub");
        calculatorServiceGrpc.calculatorServiceBlockingStub stub =
                calculatorServiceGrpc.newBlockingStub(channel);

        SumRequest sumRequest = SumRequest.newBuilder()
                .setFirstNumber(10)
                .setSecondNumber(24)
                .build();

        SumResponse sumResponse = stub.sum(sumRequest);

        System.out.println(sumRequest.getFirstNumber() + " + "+sumRequest.getSecondNumber()+" = "+sumResponse.getSumResult());
        channel.shutdown();
    }
}
