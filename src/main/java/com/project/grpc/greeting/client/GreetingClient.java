package com.project.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello I'm  gRPC client");

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",50051)
                .usePlaintext()
                .build();

        System.out.println("Greeting stub");
        DummyServiceGrpc.DummyServiceBlockingStub syncClient =
                DummyServiceGrpc.newBlockingStub(channel);

        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
