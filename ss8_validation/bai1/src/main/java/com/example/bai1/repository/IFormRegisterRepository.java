package com.example.bai1.repository;

import com.example.bai1.model.FormRegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFormRegisterRepository extends JpaRepository<FormRegisterModel,Integer> {

}
