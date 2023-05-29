package com.example.bai1.service;

import com.example.bai1.model.FormRegisterModel;

import java.util.List;

public interface IFormRegisterService {
    List<FormRegisterModel> findAll();
    void save(FormRegisterModel formRegisterModel);
}
