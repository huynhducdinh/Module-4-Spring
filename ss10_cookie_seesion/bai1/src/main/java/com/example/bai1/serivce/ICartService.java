package com.example.bai1.serivce;

import com.example.bai1.model.Cart;

import java.util.Collection;
import java.util.Map;

public interface ICartService {


    void add(Cart cart);

    void delete(Integer id);

    Cart update(Integer idProduct, Integer quantity);

    void clear();

    Collection<Cart> getAll();

    long getCount();

    double getAmount();

}
