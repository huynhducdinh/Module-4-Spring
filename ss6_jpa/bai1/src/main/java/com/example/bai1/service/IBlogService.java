package com.example.bai1.service;

import com.example.bai1.model.BlogModel;

import java.util.List;


public interface IBlogService {
    List<BlogModel> findAll();

    void save(BlogModel blogModel);
    void delete(Integer id);
   BlogModel findById(Integer id);
}
