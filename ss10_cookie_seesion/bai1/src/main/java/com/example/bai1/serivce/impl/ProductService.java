package com.example.bai1.serivce.impl;

import com.example.bai1.model.ProductShopp;
import com.example.bai1.repository.IProductRepository;
import com.example.bai1.serivce.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<ProductShopp> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public ProductShopp findById(Integer id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public ProductShopp findByIdProduct(Integer id) {
        return iProductRepository.findById(id).get();
    }
}
