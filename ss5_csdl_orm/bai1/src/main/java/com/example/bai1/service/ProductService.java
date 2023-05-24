package com.example.bai1.service;

import com.example.bai1.model.ProductModel;
import com.example.bai1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<ProductModel> getAll() {
        return iProductRepository.getAll();
    }

    @Override
    public boolean save(ProductModel productModel) {
        iProductRepository.save(productModel);
        return true;
    }

    @Override
    public void updateProductModel(ProductModel productModel) {
        iProductRepository.updateProductModel(productModel);
    }

    @Override
    public ProductModel findById(Integer id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<ProductModel> search(String name) {
        return iProductRepository.search(name);
    }
}
