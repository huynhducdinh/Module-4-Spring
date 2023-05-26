package com.example.bai1.controller;

import com.example.bai1.model.CategoryModel;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/category")
    public String listCategory(Model model) {
        List<CategoryModel> categoryModelList = iCategoryService.findAll();
        model.addAttribute("categoryModelList", categoryModelList);
        return "listCategory";
    }

    @GetMapping("/createCategory")
    public String create(Model model) {
        model.addAttribute("categoryModel", new CategoryModel());
        return "createCategory";
    }

    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute("categoryModel") CategoryModel categoryModel, RedirectAttributes attributes) {
        iCategoryService.save(categoryModel);
            attributes.addFlashAttribute("mess",true);
        return "redirect:/category";
    }

    @GetMapping("/updateCategory/{id}")
    public String editCategory(@PathVariable("id") Integer id, Model model) {
        CategoryModel categoryModel = iCategoryService.findById(id);
        model.addAttribute("categoryModel", categoryModel);
        return "updateCategory";
    }

    @PostMapping("/editCategory")
    public String updateCategory(@ModelAttribute("categoryModel") CategoryModel categoryModel,RedirectAttributes attributes) {
        iCategoryService.save(categoryModel);
        attributes.addFlashAttribute("flag",true);
        return "redirect:/category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        iCategoryService.delete(id);
        attributes.addFlashAttribute("check", true);
        return "redirect:/category";
    }
}
