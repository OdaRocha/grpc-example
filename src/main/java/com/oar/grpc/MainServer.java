package com.oar.grpc;

import com.oar.grpc.server.GreeterServer;

public class MainServer {

    /**
     * Create gRPC server with default Port 8980
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        GreeterServer greeterServer = new GreeterServer();
        greeterServer.start();
        greeterServer.blockUntilShutdown();
    }
}
