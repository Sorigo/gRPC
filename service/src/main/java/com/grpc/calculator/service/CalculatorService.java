package com.grpc.calculator.service;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CalculatorService extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        long firstNumber = request.getFirstNumber();
        long secondNumber = request.getSecondNumber();

        SumResponse response = SumResponse.newBuilder()
                .setResult(firstNumber + secondNumber)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
