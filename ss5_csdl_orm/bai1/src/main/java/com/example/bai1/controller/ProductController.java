package com.example.bai1.controller;

import com.example.bai1.model.ProductModel;
import com.example.bai1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller

public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String showProduct(Model model) {
        List<ProductModel> productModelList = iProductService.getAll();
        model.addAttribute("productModelList", productModelList);
        return "list";
    }

    @GetMapping("/createProduct")
    public String createProduct(Model model) {
        model.addAttribute("product", new ProductModel());
        return "create";
    }

    @PostMapping("/create")
    public String createProducts(@ModelAttribute("productModel")ProductModel productModel, RedirectAttributes redirect) {
      boolean check =  iProductService.save(productModel);
        redirect.addFlashAttribute("check","Thêm mới thành công");
        return "redirect:/";
//       Muốn về lại trang list thì dùm redirect:/
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, Model model) {
        ProductModel productModel = iProductService.findById(id);
        model.addAttribute("productModel", productModel);
        return "update";
    }

    @PostMapping("/update")
    public String updateProducts(@ModelAttribute("productModel")ProductModel productModel) {
        iProductService.updateProductModel(productModel);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        iProductService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable Integer id, Model model) {
        ProductModel productModel = iProductService.findById(id);
        model.addAttribute("productModel", productModel);
        return "detail";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam String name, Model model) {
        List<ProductModel> productModelList = iProductService.search(name);
        model.addAttribute("productModelList", productModelList);
        return "list";


    }


}
