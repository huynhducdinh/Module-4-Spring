package com.example.bai1.controller;

import com.example.bai1.model.BlogModel;
import com.example.bai1.model.CategoryModel;
import com.example.bai1.service.IBlogService;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;

//    @GetMapping("")
//    public ResponseEntity<List<BlogModel>> getAllBlog(){
//        return new  ResponseEntity<>(iBlogService.findAll(), HttpStatus.OK);
//    }
    @GetMapping("")
    public ResponseEntity<Page<BlogModel>> showListBlog( @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<BlogModel> blogModelList = iBlogService.findAll(page);
        return new  ResponseEntity<>(blogModelList, HttpStatus.OK);
    }
//
   @GetMapping("/category")
    public  ResponseEntity<List<CategoryModel> >getAll(){
        return new ResponseEntity<>(iCategoryService.findAll(),HttpStatus.OK);
   }
    @GetMapping("{id}/list")
    public ResponseEntity<List<BlogModel>> viewListBlogByCategory(@PathVariable("id") Integer id){
        CategoryModel categoryModel=iCategoryService.findById(id);
        return  new ResponseEntity<>(iBlogService.findAllByCategoryModel(categoryModel),HttpStatus.OK);
    }
    @GetMapping("{id}/blog")
    public ResponseEntity<BlogModel> detailBlog(@PathVariable("id") Integer id){
        iBlogService.findById(id);
        return new  ResponseEntity<>( HttpStatus.OK);

    }
    @GetMapping("/searchBlog")
    public ResponseEntity<List<BlogModel>> searchBlog(@RequestParam("titles") String titles){
        List<BlogModel> blogModels= iBlogService.searchBlog(titles);
        return new ResponseEntity<>(blogModels, HttpStatus.OK);
    }
    @GetMapping("/loadMore")
    public ResponseEntity<Slice<BlogModel>> loadMore(@RequestParam("page")Integer page){
        return new ResponseEntity<>(iBlogService.findAllBlog(page), HttpStatus.OK);
    }

}
