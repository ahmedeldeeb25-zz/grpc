package com.project.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        try {
            System.out.println("Hello I'm  gRPC client");

            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();

            System.out.println("Greeting stub");
            // Create blocking - sync Stub
            GreetServiceGrpc.GreetServiceBlockingStub stub = GreetServiceGrpc.newBlockingStub(channel);
            // create protocol buffer for greeting message
            Greeting greeting = Greeting.newBuilder()
                    .setFirstName("Ahmed")
                    .setLastName("Eldeeb")
                    .build();
            // Add greeting to GreetRequest - Unary
            /*
            GreetRequest greetRequest = GreetRequest.newBuilder()
                    .setGreeting(greeting)
                    .build();

            // Call gRPC and get back the response
            GreetResponse greetResponse = stub.greet(greetRequest);
            */
            GreetManyTimeRequest greetManyTimeRequest = GreetManyTimeRequest.newBuilder().setGreeting(greeting).build();
            stub.greetMany(greetManyTimeRequest).forEachRemaining(greetManyTimeResponse -> {
                System.out.println(greetManyTimeResponse);
            });
            channel.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
