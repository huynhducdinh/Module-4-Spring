package com.example.bai1.repository;

import com.example.bai1.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IBorrowRepository extends JpaRepository<Borrow,Integer> {
    Borrow findCodeByCodeName(Integer codeName);
}
