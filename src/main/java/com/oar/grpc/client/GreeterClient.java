package com.oar.grpc.client;

import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.Message;
import com.oar.grpc.greeter.GreeterGrpc;
import com.oar.grpc.greeter.GreeterGrpc.GreeterBlockingStub;
import com.oar.grpc.greeter.GreeterGrpc.GreeterStub;
import com.oar.grpc.greeter.HelloReply;
import com.oar.grpc.greeter.HelloRequest;
import io.grpc.Channel;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.oar.grpc.server.GreeterServer.DEFAULT_PORT;

public class GreeterClient {

    public static final String SERVER_ENDPOINT = "localhost:" + DEFAULT_PORT;
    private static final Logger logger = Logger.getLogger(GreeterClient.class.getName());


    private final GreeterBlockingStub greeterBlockingStub;
    private final GreeterStub greeterStub;

    public GreeterClient(Channel channel) {
        greeterBlockingStub = GreeterGrpc.newBlockingStub(channel);
        greeterStub = GreeterGrpc.newStub(channel);
    }

    public void sayHello(String name) {
        HelloRequest helloReq = HelloRequest.newBuilder()
                .setName(name)
                .build();

        HelloReply helloReply = greeterBlockingStub.sayHello(helloReq);
        logger.info(helloReply.getMessage());
    }

    public void sayHelloAgain(String name) {
        HelloRequest helloReq = HelloRequest.newBuilder()
                .setName(name)
                .build();

        HelloReply helloReply = greeterBlockingStub.sayHelloAgain(helloReq);
        logger.info(helloReply.getMessage());
    }


}
