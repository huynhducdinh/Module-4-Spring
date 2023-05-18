package com.example.bai1.service.impl;

import com.example.bai1.service.IChuyenDoiService;
import org.springframework.stereotype.Service;

@Service
public class ChuyenDoiService implements IChuyenDoiService {

    @Override
    public float chuyenDoi(float usd, float vnd) {
        float result = usd * vnd;
        return result;
    }
}
