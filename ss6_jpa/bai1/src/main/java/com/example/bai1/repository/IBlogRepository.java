package com.example.bai1.repository;

import com.example.bai1.model.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogModel,Integer> {

}
