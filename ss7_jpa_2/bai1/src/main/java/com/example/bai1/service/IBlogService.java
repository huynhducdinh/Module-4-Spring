package com.example.bai1.service;

import com.example.bai1.model.BlogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {
    Page<BlogModel> findAll(int page);

    void save(BlogModel blogModel);
    void delete(Integer id);
   BlogModel findById(Integer id);
    List<BlogModel> findAllByTitlesContaining(String titles);

}
