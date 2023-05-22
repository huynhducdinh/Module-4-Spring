package com.example.bai1.service;

import com.example.bai1.model.ElectronicMailBoxModel;
import com.example.bai1.repository.ElectronicMailBoxRepository;
import com.example.bai1.repository.IElectronicMailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ElectronicMailBoService implements  IElectronicMailBoService{

    @Autowired
    private  IElectronicMailBoxRepository iElectronicMailBoxRepository;


    @Override
    public ElectronicMailBoxModel getAll() {
        return  iElectronicMailBoxRepository.getAll().get(0);

    }

    @Override
    public void save(ElectronicMailBoxModel electronicMailBoxModel) {
        iElectronicMailBoxRepository.save(electronicMailBoxModel);
    }

    @Override
    public ElectronicMailBoxModel update() {
        return iElectronicMailBoxRepository.getAll().get(0);

    }
}
