package com.example.bai1.controller;

import com.example.bai1.model.BlogModel;
import com.example.bai1.model.CategoryModel;
import com.example.bai1.service.IBlogService;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/blog")
    public ResponseEntity<List<BlogModel>> getAllBlog(){
        return new  ResponseEntity<>(iBlogService.findAll(), HttpStatus.OK);
    }
   @GetMapping("/category")
    public  ResponseEntity<List<CategoryModel> >getAll(){
        return new ResponseEntity<>(iCategoryService.findAll(),HttpStatus.OK);
   }
   @GetMapping("{id}/list")
    public ResponseEntity<List<BlogModel>> viewCategory(@PathVariable("id") Integer id){
        CategoryModel categoryModel=iCategoryService.findById(id);
      return  new ResponseEntity<>(iBlogService.findAllByCategoryModel(categoryModel),HttpStatus.OK);
   }
    @GetMapping("{id}/blog")
    public ResponseEntity<BlogModel> view(@PathVariable("id") Integer id){
        iBlogService.findById(id);
        return new  ResponseEntity<>( HttpStatus.OK);

    }
}
