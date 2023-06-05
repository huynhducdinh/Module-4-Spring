package com.example.bai1.service.impl;

import com.example.bai1.model.BlogModel;
import com.example.bai1.model.CategoryModel;
import com.example.bai1.repository.IBlogRepository;
import com.example.bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<BlogModel> findAll(Integer page) {
        return iBlogRepository.findAll(PageRequest.of(page, 5, Sort.by("id").descending()));
    }

    @Transactional
    @Override
    public void save(BlogModel blogModel) {
        iBlogRepository.save(blogModel);

    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public BlogModel findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public List<BlogModel> findAllByCategoryModel(CategoryModel categoryModel) {
        return iBlogRepository.findAllByCategoryModel(categoryModel);
    }

    @Override
    public Page<BlogModel> searchBlog(String title, Integer page) {
        return iBlogRepository.findCategory(title, Pageable.unpaged());
    }

    @Override
    public List<BlogModel> searchBlog(String title) {
        return iBlogRepository.findBlog(title);
    }

    @Override
    public Slice<BlogModel> findAllBlog(Integer pageable) {
        return iBlogRepository.findAllBlog(Pageable.unpaged());
    }


}
