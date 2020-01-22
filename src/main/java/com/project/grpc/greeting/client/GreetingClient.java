package com.project.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class GreetingClient {

    public static void main(String[] args) {
        try {
            System.out.println("Hello I'm  gRPC client");

            GreetingClient greetingClient = new GreetingClient();
            greetingClient.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        //    doUnaryCall(channel);
        //    doServerStreamingCall(channel);
        //    doClientStreamingCall(channel);
        doBiDirectionalStreamingCall(channel);

        channel.shutdown();
    }

    private void doServerStreamingCall(ManagedChannel channel) {
        GreetServiceGrpc.GreetServiceBlockingStub stub = GreetServiceGrpc.newBlockingStub(channel);
        // create protocol buffer for greeting message
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Ahmed")
                .setLastName("Eldeeb")
                .build();

        GreetManyTimeRequest greetManyTimeRequest = GreetManyTimeRequest.newBuilder().setGreeting(greeting).build();
        stub.greetMany(greetManyTimeRequest).forEachRemaining(greetManyTimeResponse -> {
            System.out.println(greetManyTimeResponse);
        });
    }

    private void doUnaryCall(ManagedChannel channel) {
        // Add greeting to GreetRequest - Unary
        GreetServiceGrpc.GreetServiceBlockingStub stub = GreetServiceGrpc.newBlockingStub(channel);
        // create protocol buffer for greeting message
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Ahmed")
                .setLastName("Eldeeb")
                .build();
        GreetRequest greetRequest = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

        // Call gRPC and get back the response
        GreetResponse greetResponse = stub.greet(greetRequest);

        System.out.println(greetResponse.getResult());

    }

    private void doClientStreamingCall(ManagedChannel channel) {
        // create async client
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<LongGreetRequest> requestObserver = asyncClient.longGreet(new StreamObserver<LongGreetResponse>() {
            @Override
            public void onNext(LongGreetResponse value) {
                System.out.println("Received a response from the server");
                System.out.println(value.getResult());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Server has Completed sending us data");
                latch.countDown();
            }
        });
        Arrays.asList("Ahmed", "Malek", "Zizo").forEach(name -> {
            System.out.println("Message from Client streaming => " + name);
            requestObserver.onNext(LongGreetRequest.newBuilder()
                    .setGreeting(Greeting.newBuilder()
                            .setFirstName(name).setLastName("Eldeeb")
                            .build())
                    .build());
        });

        // Tell the server that the client is done sending data
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void doBiDirectionalStreamingCall(ManagedChannel channel) {
        // create async client
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<LongGreetRequest> requestObserver = asyncClient.longGreet(new StreamObserver<LongGreetResponse>() {
            @Override
            public void onNext(LongGreetResponse value) {
                System.out.println("Received a response from the server");
                System.out.println(value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server has Completed sending us data");
                latch.countDown();
            }
        });
        Arrays.asList("Ahmed", "Malek", "Zizo").forEach(name -> {
            System.out.println("Message from Bi-directional => " + name);
            requestObserver.onNext(LongGreetRequest.newBuilder()
                    .setGreeting(Greeting.newBuilder()
                            .setFirstName(name).setLastName("Eldeeb")
                            .build())
                    .build());
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        });

        // Tell the server that the client is done sending data
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
