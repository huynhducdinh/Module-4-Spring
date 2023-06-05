package com.example.bai1.service.impl;

import com.example.bai1.model.BlogModel;
import com.example.bai1.model.CategoryModel;
import com.example.bai1.repository.IBlogRepository;
import com.example.bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<BlogModel> findAll(int page) {
        return iBlogRepository.findAll(PageRequest.of(page, 2, Sort.by("dayCreate").descending()));
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
    public List<BlogModel> findAllByTitlesContaining(String titles) {
        return iBlogRepository.findAllByTitlesContaining(titles);
    }

    @Override
    public List<BlogModel> findAll() {
        return iBlogRepository.findAll();
    }
    @Override
    public List<BlogModel> findAllByCategoryModel(CategoryModel categoryModel) {
        return iBlogRepository.findAllByCategoryModel(categoryModel);
    }

    @Override
    public Page<BlogModel> searchBlog(String title, Integer page) {
        return iBlogRepository.findCategory(title, Pageable.unpaged());
    }


}
