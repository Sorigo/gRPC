package com.grpc.calculator.client.service;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @GrpcClient("calculator-service")
    private CalculatorServiceGrpc.CalculatorServiceBlockingStub blockingStub;

    public long sum(long firstNumber, long secondNumber) {
        SumRequest sumRequest = SumRequest.newBuilder()
                .setFirstNumber(firstNumber)
                .setSecondNumber(secondNumber)
                .build();
        SumResponse sum = blockingStub.sum(sumRequest);
        return sum.getResult();
    }

}
