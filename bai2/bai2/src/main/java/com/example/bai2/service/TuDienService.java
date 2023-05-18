package com.example.bai2.service;

import com.example.bai2.reporsitory.ITuDienReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TuDienService implements ITuDienService {
    @Autowired
    private ITuDienReprository iTuDienReprository;

    @Override
    public String tuDien(String english) {
        Map<String, String> stringSet = iTuDienReprository.tuDien();
        String result = "Không tìm thấy từ bạn muốn dịch";
        for (Map.Entry<String, String> stringEntry : stringSet.entrySet()) {
            if (stringEntry.getKey().equals(english)) {
                result = stringEntry.getValue();
            }
        }
        return result;
    }
}
