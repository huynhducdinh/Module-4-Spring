package com.example.bai1.serivce;

import com.example.bai1.model.ProductShopp;

import java.util.List;

public interface IProductService  {
    List<ProductShopp> findAll();
    ProductShopp findById(Integer id);
    ProductShopp findByIdProduct(Integer id);

}
