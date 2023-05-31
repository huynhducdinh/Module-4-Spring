package com.example.bai1.service;

import com.example.bai1.model.Book;
import com.example.bai1.model.Order;
import com.example.bai1.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrderService implements IOrderService{
    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
     IBookService iBookService;
    @Override
    public List<Order> findAll() {
            return iOrderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        iOrderRepository.save(order);
    }

    @Override
    public String findByCode() {
        String code = String.valueOf(new Random().nextInt(90000) + 10000);
        List<Order> oderList = findAll();
        for (int i = 0; i < oderList.size(); i++) {
            if (code.equals(oderList.get(i).getCode())) {
                code = String.valueOf(new Random().nextInt(90000) + 10000);
                i =0;
            }
        }
        return code;
    }

    @Override
    public void delete(int id) {
        iOrderRepository.deleteById(id);
    }

    @Override
    public void returnBook(String code) {
        List<Order> oderList = iOrderRepository.findAll();
        for (int i = 0; i < oderList.size(); i++) {
            if (code.equals(oderList.get(i).getCode())) {
                Book book = iBookService.findById(oderList.get(i).getBookId());
                book.setQuantity(book.getQuantity() + 1);
                iBookService.save(book);

            }
        }
    }
}
