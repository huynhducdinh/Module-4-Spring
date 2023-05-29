package com.example.bai1.service;

import com.example.bai1.model.CategoryModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    Page<CategoryModel> findAll(int page);
    void  save(CategoryModel categoryModel);
    CategoryModel findById (Integer id);
     void delete(Integer id);

}
