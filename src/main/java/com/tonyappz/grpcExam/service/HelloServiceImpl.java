package com.tonyappz.grpcExam.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = request.getFirstName() + " " + request.getLastName();
        HelloResponse response = HelloResponse.newBuilder()
                        .addGreeting(greeting)
                                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
//        super.hello(request, responseObserver);
    }
}
