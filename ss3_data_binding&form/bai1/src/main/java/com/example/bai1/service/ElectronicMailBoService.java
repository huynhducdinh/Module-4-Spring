package com.example.bai1.service;

import com.example.bai1.model.ElectronicMailBoxModel;
import com.example.bai1.repository.ElectronicMailBoxRepository;
import com.example.bai1.repository.IElectronicMailBoxRepository;

import java.util.List;

public class ElectronicMailBoService implements  IElectronicMailBoService{
    private IElectronicMailBoxRepository iElectronicMailBoxRepository=new ElectronicMailBoxRepository();

    @Override
    public List<String> languagesList() {
        return iElectronicMailBoxRepository.languagesList();
    }

    @Override
    public List<String> pageSizeList() {
        return iElectronicMailBoxRepository.pageSizeList();
    }
}
