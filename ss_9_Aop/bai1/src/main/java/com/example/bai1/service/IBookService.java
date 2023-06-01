package com.example.bai1.service;

import com.example.bai1.model.Book;
import com.example.bai1.model.Borrow;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    void saveBook(Book book);
    boolean save(Book book);


}
