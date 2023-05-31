package com.example.bai1.repository;

import com.example.bai1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
