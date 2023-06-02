package com.example.bai1.controller;

import com.example.bai1.model.Cart;
import com.example.bai1.model.ProductShopp;
import com.example.bai1.serivce.ICartService;
import com.example.bai1.serivce.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
   private ICartService iCartService;

    @GetMapping("/")
    public  String displayList( Model model){
        List<ProductShopp> productShoppList=iProductService.findAll();
        model.addAttribute("productShoppList",productShoppList);
        long count= iCartService.getCount();
        model.addAttribute("count",count);
        return "list";
    }

    @GetMapping("/viewProduct/{id}")
    public String view(@PathVariable("id")Integer id,Model model){
        ProductShopp productShopp=iProductService.findById(id);
        model.addAttribute("productShopp",productShopp);
        return "detail";
    }
    @ModelAttribute("cart")
    public Map<Integer,Cart> initCart(){
        return new HashMap<>();
    }

}
