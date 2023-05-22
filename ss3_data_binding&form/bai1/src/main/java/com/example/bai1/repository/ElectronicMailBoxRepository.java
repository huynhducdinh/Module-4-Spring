package com.example.bai1.repository;
import com.example.bai1.model.ElectronicMailBoxModel;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ElectronicMailBoxRepository implements  IElectronicMailBoxRepository{

 private static List<ElectronicMailBoxModel> electronicMailBoxModels=new ArrayList<>();
    static {
        electronicMailBoxModels.add(new ElectronicMailBoxModel("English", 15, true, "Hello"));
    }


    @Override
    public List<ElectronicMailBoxModel> getAll() {
        return electronicMailBoxModels;
    }

    @Override
    public void save(ElectronicMailBoxModel electronicMailBoxModel) {
        electronicMailBoxModels.get(0).setLanguage(electronicMailBoxModel.getLanguage());
        electronicMailBoxModels.get(0).setPageSize(electronicMailBoxModel.getPageSize());
        electronicMailBoxModels.get(0).setSpamsFilter(electronicMailBoxModel.getSpamsFilter());
        electronicMailBoxModels.get(0).setSignature(electronicMailBoxModel.getSignature());
    }

}
