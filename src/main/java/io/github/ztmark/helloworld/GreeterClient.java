package io.github.ztmark.helloworld;

import java.util.concurrent.TimeUnit;

import helloworld.GreeterServiceGrpc;
import helloworld.HelloReply;
import helloworld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Author: Mark
 * Date  : 2017/12/15
 */
public class GreeterClient {

    public static void main(String[] args) throws InterruptedException {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext(true).build();
        final GreeterServiceGrpc.GreeterServiceBlockingStub blockingStub = GreeterServiceGrpc.newBlockingStub(channel);
        final HelloReply reply = blockingStub.sayHello(HelloRequest.newBuilder().setName("Mark").build());
        System.out.println("received from server " + reply.getGreeting());
        channel.shutdown();
        channel.awaitTermination(5, TimeUnit.SECONDS);
    }

}
