package com.example.bai1.controller;

import com.example.bai1.model.CategoryModel;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("/category")
    public ResponseEntity<List<CategoryModel>> getAll(){
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }
}
