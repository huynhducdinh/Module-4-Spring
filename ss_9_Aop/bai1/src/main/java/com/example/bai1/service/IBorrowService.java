package com.example.bai1.service;

import com.example.bai1.model.Book;
import com.example.bai1.model.Borrow;


import java.util.List;

public interface IBorrowService {
    List<Borrow> findAll();
    void saveBook(Borrow order);
    Borrow checkCodeName(Integer codeName);
    Borrow getByCodeName(Integer codeName);

    int checkCode(List<Borrow> borrows);
    void save(Borrow borrow);
}
