package com.oar.grpc;

import com.oar.grpc.client.GreeterClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class MainClient {

    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(GreeterClient.SERVER_ENDPOINT).usePlaintext().build();

        try {
            GreeterClient client = new GreeterClient(channel);
            client.sayHello("Odair");
            client.sayHelloAgain("Odair");

        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

}
