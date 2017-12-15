package io.github.ztmark.helloworld;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Author: Mark
 * Date  : 2017/12/15
 */
public class GreeterServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        final Server server = ServerBuilder.forPort(8080)
                                          .addService(new GreeterServiceImpl())
                                          .build();

        server.start();
        System.out.println("server started...");
        server.awaitTermination();
    }

}
