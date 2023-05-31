package com.example.bai1.service;

import com.example.bai1.model.Book;
import com.example.bai1.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements  IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void saveBook(Book book) {
        iBookRepository.save(book);

    }

    @Override
    public boolean save(Book book) {
        int quantity= book.getQuantity()-1;
        if (quantity<0){
            return false;
        }
        book.setQuantity(quantity);
        iBookRepository.save(book);
        return true;
    }
}
