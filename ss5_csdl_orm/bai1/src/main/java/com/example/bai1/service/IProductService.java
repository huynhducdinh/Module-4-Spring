package com.example.bai1.service;

import com.example.bai1.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> getAll();

    boolean save(ProductModel productModel);
//
    void updateProductModel ( ProductModel productModel);
    ProductModel findById(Integer id);
//
    boolean delete(Integer id);
//
    List<ProductModel> search(String name);

}
