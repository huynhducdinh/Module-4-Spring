package com.example.bai1.repository;

import com.example.bai1.model.ProductModel;

import java.util.List;

public interface IProductRepository {
    List<ProductModel> getAll();

    boolean save(ProductModel productModel);
//
    void updateProductModel(ProductModel productModel);
//
    ProductModel findById(Integer id);
//
    boolean delete(Integer id);
//
    List<ProductModel> search(String name);

}
