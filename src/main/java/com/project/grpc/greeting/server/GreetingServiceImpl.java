package com.project.grpc.greeting.server;

import com.proto.greet.*;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {

        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();

        String greetingMSG = "Hello "+firstName;
        GreetResponse response = GreetResponse.newBuilder().setResult(greetingMSG).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void greetMany(GreetManyTimeRequest request, StreamObserver<GreetManyTimeResponse> responseObserver) {
        String firstName = request.getGreeting().getFirstName();

        try {
            for (int i = 0; i < 10; i++) {
                String result = "Hello " + firstName +", Response number : "+i;
                GreetManyTimeResponse response = GreetManyTimeResponse.newBuilder().setResult(result).build();

                responseObserver.onNext(response);
                Thread.sleep(1000L);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            responseObserver.onCompleted();
        }
    }
}
