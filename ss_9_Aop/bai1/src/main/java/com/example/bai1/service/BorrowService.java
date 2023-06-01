package com.example.bai1.service;


import com.example.bai1.model.Book;
import com.example.bai1.model.Borrow;
import com.example.bai1.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository iOrderRepository;


    @Override
    public List<Borrow> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public void saveBook(Borrow order) {
        iOrderRepository.save(order);
    }

    @Override
    public Borrow checkCodeName(Integer codeName) {
      return iOrderRepository.findById(codeName).get();
    }

    @Override
    public Borrow getByCodeName(Integer codeName) {
        return iOrderRepository.findCodeByCodeName(codeName);
    }
    @Override
    public int checkCode(List<Borrow> borrows) {
        boolean check;
        int codeName;
        do {
            check = true;
            codeName = getRandomNumber(10000, 99999);

            for (int i = 0; i < borrows.size(); i++) {
                if (borrows.get(i).getCodeName() == codeName) {
                    check = false;
                }
            }
        } while (!check);
        return codeName;
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    @Override
    public  void save(Borrow borrow){
        iOrderRepository.save(borrow);
    }
}
