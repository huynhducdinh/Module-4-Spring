package com.example.bai1.service;


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
    public boolean checkCodeName(Integer codeName) {
        List<Borrow> orderList = iOrderRepository.findAll();
        for (int i=0;i<orderList.size();i++){
            if (orderList.get(i).getCodeName().equals(codeName) && orderList.get(i).isStatus()){
                return true;
            }
        }
        return false;
    }

    @Override
    public Borrow getByCodeName(Integer codeName) {
        return iOrderRepository.findCodeByCodeName(codeName);
    }
}
