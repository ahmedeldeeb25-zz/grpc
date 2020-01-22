package com.project.grpc.greeting.server;

import com.proto.greet.*;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {

        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();

        String greetingMSG = "Hello " + firstName;
        GreetResponse response = GreetResponse.newBuilder().setResult(greetingMSG).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void greetMany(GreetManyTimeRequest request, StreamObserver<GreetManyTimeResponse> responseObserver) {
        String firstName = request.getGreeting().getFirstName();

        try {
            for (int i = 0; i < 10; i++) {
                String result = "Hello " + firstName + ", Response number : " + i;
                GreetManyTimeResponse response = GreetManyTimeResponse.newBuilder().setResult(result).build();

                responseObserver.onNext(response);
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<LongGreetRequest> longGreet(StreamObserver<LongGreetResponse> responseObserver) {
        StreamObserver<LongGreetRequest> requestObserver = new StreamObserver<LongGreetRequest>() {

            String result = "";

            @Override
            public void onNext(LongGreetRequest value) {
                result += "Hello " + value.getGreeting().getFirstName() + "! ";
            }

            @Override
            public void onError(Throwable t) {
                // client sends an error
            }

            @Override
            public void onCompleted() {
                // Client is done
                LongGreetResponse longGreetResponse = LongGreetResponse.newBuilder().setResult(result).build();
                responseObserver.onNext(longGreetResponse);
                responseObserver.onCompleted();
            }
        };
        return requestObserver;
    }

    @Override
    public StreamObserver<GreetEveryOneRequest> greetEveryOne(StreamObserver<GreetEveryOneResponse> responseObserver) {
        StreamObserver<GreetEveryOneRequest> requestObserver = new StreamObserver<GreetEveryOneRequest>() {
            @Override
            public void onNext(GreetEveryOneRequest value) {
                String result = "Hello " + value.getGreeting().getFirstName();
                GreetEveryOneResponse greetEveryOneResponse = GreetEveryOneResponse.newBuilder()
                        .setResult(result)
                        .build();

                responseObserver.onNext(greetEveryOneResponse);

            }

            @Override
            public void onError(Throwable t) {
                // do nothing
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
        return requestObserver;
    }
}
