package com.example.bai1.service.impl;

import com.example.bai1.model.CategoryModel;
import com.example.bai1.repository.ICategoryRepository;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<CategoryModel> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Page<CategoryModel> findAll(int page) {
        return iCategoryRepository.findAll(PageRequest.of(page, 3, Sort.by("id").descending()));
    }

    @Transactional
    @Override
    public void save(CategoryModel categoryModel) {
        iCategoryRepository.save(categoryModel);
    }

    @Override
    public CategoryModel findById(Integer id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        iCategoryRepository.deleteById(findById(id).getId());
    }

}
