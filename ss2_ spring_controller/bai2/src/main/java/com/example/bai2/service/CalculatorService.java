package com.example.bai2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements  ICalculatorService{

    @Override
    public float multiplication(float numberOne, float numberTwo) {
        float multiplication=numberOne * numberTwo;
        return multiplication;
    }

    @Override
    public float division(float numberOne, float numberTwo) {
        float division=numberOne / numberTwo;
        return division;
    }

    @Override
    public float addition(float numberOne, float numberTwo) {
        float addition=numberOne + numberTwo;
        return addition;
    }

    @Override
    public float subtraction(float numberOne, float numberTwo) {
        float subtraction=numberOne - numberTwo;
        return subtraction;
    }
}
