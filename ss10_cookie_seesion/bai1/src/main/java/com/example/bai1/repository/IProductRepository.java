package com.example.bai1.repository;

import com.example.bai1.model.ProductShopp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<ProductShopp, Integer> {

}
