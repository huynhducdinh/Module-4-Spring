package com.example.bai1.controller;

import com.example.bai1.model.BlogModel;
import com.example.bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
    public String listBlog(Model model) {
        List<BlogModel> blogModelList = iBlogService.findAll();
        model.addAttribute("blogModelList", blogModelList);
        return "list";

    }

    @GetMapping("/createBlog")
    public String createBlog(Model model) {
        model.addAttribute("blogModel", new BlogModel());
        return "create";
    }

    @PostMapping("/create")
    public String createBlogs(@ModelAttribute("blogModel") BlogModel blogModel , RedirectAttributes attributes) {
        LocalDateTime create = LocalDateTime.now();
        blogModel.setDayCreate(create);
       iBlogService.save(blogModel);
       attributes.addFlashAttribute("mess","ADD");
        return "redirect:/createBlog";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam("id") Integer id) {
        iBlogService.delete(id);
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
        model.addAttribute("blogModel",blogModel);
        return "update";
    }
    @PostMapping("/update")
    public String editBlog(@ModelAttribute("blogModel") BlogModel blogModel){
        LocalDateTime update=LocalDateTime.now();
        blogModel.setDayUpdate(update);
        iBlogService.save(blogModel);
        return "redirect:/";
    }
}
