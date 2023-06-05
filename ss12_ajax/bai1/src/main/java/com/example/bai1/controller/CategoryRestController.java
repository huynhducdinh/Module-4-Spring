package com.example.bai1.controller;

import com.example.bai1.model.CategoryModel;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryRestController {

    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("/category")
    public ResponseEntity<List<CategoryModel>> getAll(){
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }
}
