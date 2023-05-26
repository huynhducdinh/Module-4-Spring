package com.example.bai1.controller;

import com.example.bai1.model.BlogModel;
import com.example.bai1.service.IBlogService;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

//    @GetMapping("/")
//    public String listBlog( Model model) {
//        List<BlogModel> blogModelList = iBlogService.findAll();
//        model.addAttribute("blogModelList", blogModelList);
//        return "list";
//
//    }

    @GetMapping("/")
    public String showListBlog(Model model,@RequestParam(value = "page",defaultValue = "0")int page){
        Page<BlogModel>blogModelList=iBlogService.findAll( page);
        model.addAttribute("blogModelList",blogModelList);
        return "list";
    }

    @GetMapping("/createBlog")
    public String createBlog(Model model) {
        model.addAttribute("blogModel", new BlogModel());
        model.addAttribute("category", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createBlogs(@ModelAttribute("blogModel") BlogModel blogModel , RedirectAttributes attributes) {
        LocalDateTime create = LocalDateTime.now();
        blogModel.setDayCreate(create);
       iBlogService.save(blogModel);
       attributes.addFlashAttribute("mess",true);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Integer id,RedirectAttributes attributes) {
        iBlogService.delete(id);
        attributes.addFlashAttribute("check",true);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable Integer id, Model model) {
        BlogModel blogModel = iBlogService.findById(id);
        model.addAttribute("blogModelList", blogModel);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String updateBlog(@PathVariable Integer id, Model model) {
        BlogModel blogModel=iBlogService.findById(id);
        model.addAttribute("category", iCategoryService.findAll());
        model.addAttribute("blogModel",blogModel);
        return "update";
    }
    @PostMapping("/update")
    public String editBlog(@ModelAttribute("blogModel") BlogModel blogModel,RedirectAttributes attributes){
        LocalDateTime update=LocalDateTime.now();
        blogModel.setDayUpdate(update);
        iBlogService.save(blogModel);
        attributes.addFlashAttribute("flag",true);
        return "redirect:/";
    }
    @GetMapping ("/search")
    public String searchBolg(@RequestParam String titles ,Model model){
       List<BlogModel>blogModel= iBlogService.findAllByTitlesContaining(titles);
        model.addAttribute("blogModel",blogModel);
        return "list";

    }
}
