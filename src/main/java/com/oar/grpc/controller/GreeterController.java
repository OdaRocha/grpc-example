package com.oar.grpc.controller;

import com.oar.grpc.greeter.GreeterGrpc.GreeterImplBase;
import com.oar.grpc.greeter.HelloReply;
import com.oar.grpc.greeter.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterController extends GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello again " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
