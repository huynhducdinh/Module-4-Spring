package com.example.bai2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {




        @Override
        public Float calculateResult (Float numberOne, Float numberTwo, String math) {
            Float result;
            switch (math) {
                case "multiplication": {
                    result = numberOne * numberTwo;
                    break;
                }
                case "division": {
                    result = numberOne / numberTwo;
                    break;
                }
                case "addition": {
                    result = numberOne + numberTwo;
                    break;
                }
                case "subtraction": {
                    result = numberOne - numberTwo;
                    break;
                }
                default: {
                    result = null;
                }
            }
            return result;
        }
    }

