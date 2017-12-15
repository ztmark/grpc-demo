package io.github.ztmark.helloworld;

import helloworld.GreeterServiceGrpc;
import helloworld.HelloReply;
import helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

/**
 * Author: Mark
 * Date  : 2017/12/15
 */
public class GreeterServiceImpl extends GreeterServiceGrpc.GreeterServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("received from client + " + request);
        responseObserver.onNext(HelloReply.newBuilder().setGreeting("hello " + request.getName()).build());
        responseObserver.onCompleted();
    }
}
