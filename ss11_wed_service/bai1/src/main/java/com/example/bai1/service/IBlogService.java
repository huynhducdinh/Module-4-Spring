package com.example.bai1.service;

import com.example.bai1.model.BlogModel;
import com.example.bai1.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {
    Page<BlogModel> findAll(int page);

    void save(BlogModel blogModel);
    void delete(Integer id);
   BlogModel findById(Integer id);
    List<BlogModel> findAllByTitlesContaining(String titles);

    List<BlogModel> findAll();
    List<BlogModel> findAllByCategoryModel(CategoryModel categoryModel);
    Page<BlogModel> searchBlog(String title,Integer page);
}
