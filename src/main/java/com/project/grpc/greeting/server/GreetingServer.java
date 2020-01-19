package com.project.grpc.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC server");

        Server server = ServerBuilder.forPort(50051).build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread( ()->{
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("successfully Stopped the server");
        }));

        server.awaitTermination();
    }
}
