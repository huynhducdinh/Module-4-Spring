package com.example.bai1.service;

import com.example.bai1.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    void save(Order oder);
    String findByCode();
    void delete(int id);

    void returnBook(String code);
}
