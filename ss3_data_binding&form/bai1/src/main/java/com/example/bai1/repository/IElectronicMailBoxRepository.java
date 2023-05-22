package com.example.bai1.repository;

import com.example.bai1.model.ElectronicMailBoxModel;

import java.util.List;

public interface IElectronicMailBoxRepository {
    List<ElectronicMailBoxModel> getAll();
    void save(ElectronicMailBoxModel electronicMailBoxModel);

}
