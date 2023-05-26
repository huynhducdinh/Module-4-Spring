package com.example.bai1.repository;

import com.example.bai1.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICategoryRepository  extends JpaRepository<CategoryModel,Integer> {
    List<CategoryModel> findAllByStatusIsFalse();
    @Query(value = "update category set status= 1 where id= :id")
    @Modifying
    @Transactional
    void deleteById(@Param("id")Integer id);

}
