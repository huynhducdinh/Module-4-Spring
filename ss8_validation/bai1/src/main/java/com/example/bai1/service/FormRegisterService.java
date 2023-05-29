package com.example.bai1.service;

import com.example.bai1.model.FormRegisterModel;
import com.example.bai1.repository.IFormRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormRegisterService implements IFormRegisterService {
    @Autowired
    IFormRegisterRepository iFormRegisterRepository;
    @Override
    public List<FormRegisterModel> findAll() {
        return iFormRegisterRepository.findAll();
    }

    @Override
    public void save(FormRegisterModel formRegisterModel) {
        iFormRegisterRepository.save(formRegisterModel);
    }
}
