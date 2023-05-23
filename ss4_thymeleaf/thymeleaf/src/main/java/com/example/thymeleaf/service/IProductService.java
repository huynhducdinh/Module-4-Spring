package com.example.thymeleaf.service;

import com.example.thymeleaf.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> getAll();

    void save(ProductModel productModel);

    void updateProductModel ( ProductModel productModel);
    ProductModel findById(Integer id);

    void delete(Integer id);

    List<ProductModel> search(String name);

}
