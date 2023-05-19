package com.example.bai1.service.impl;

import com.example.bai1.service.ICurrencyConversionService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {

    @Override
    public float convert(float usd, float vnd) {
        float result = usd * vnd;
        return result;
    }
}
