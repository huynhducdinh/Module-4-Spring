package com.example.bai1.service;

import com.example.bai1.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    void  save(CategoryModel categoryModel);
    CategoryModel findById (Integer id);
     void delete(Integer id);

}
