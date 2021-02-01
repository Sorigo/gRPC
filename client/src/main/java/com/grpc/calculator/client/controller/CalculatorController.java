package com.grpc.calculator.client.controller;

import com.grpc.calculator.client.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/sum")
    public Long sum( @RequestParam long firstNumber, @RequestParam long secondNumber) {
        return this.calculatorService.sum(firstNumber, secondNumber);
    }

}
