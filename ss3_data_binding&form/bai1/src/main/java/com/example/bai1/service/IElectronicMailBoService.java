package com.example.bai1.service;

import com.example.bai1.model.ElectronicMailBoxModel;

import java.util.List;

public interface IElectronicMailBoService {


   ElectronicMailBoxModel getAll();

   void save(ElectronicMailBoxModel electronicMailBoxModel);
   ElectronicMailBoxModel  update();

}
