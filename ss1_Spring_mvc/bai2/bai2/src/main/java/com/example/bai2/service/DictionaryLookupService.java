package com.example.bai2.service;

import com.example.bai2.reporsitory.IDictionaryLookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryLookupService implements IDictionaryLookupService {
    @Autowired
    private IDictionaryLookupRepository iDictionaryLookupRepository;

    @Override
    public String dictionaryLookupRepository(String english) {
        Map<String, String> stringSet = iDictionaryLookupRepository.dictionaryLookupRepository();
     String result=   stringSet.get(english);
    if (result==null){
        result="Không tìm thấy từ mà bạn muốn tra";
    }
        return result;
    }
}
