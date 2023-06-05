package com.example.bai1.repository;

import com.example.bai1.model.BlogModel;
import com.example.bai1.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogModel, Integer> {

    List<BlogModel> findAllByTitlesContaining(String titles);

    //    List<BlogModel> findAllByStatusIsFalse();
//
//    @Query(value = "update BlogModel set status= 1 where id= :id")
//    @Modifying
//    @Transactional
//    void deleteById(@Param("id") Integer id);
//
//    Page<BlogModel> getAllPage(Integer page);
    List<BlogModel> findAllByCategoryModel(CategoryModel categoryModel);
}
