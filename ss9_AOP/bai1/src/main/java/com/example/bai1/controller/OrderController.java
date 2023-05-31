package com.example.bai1.controller;

import com.example.bai1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @Autowired
    private IOrderService oderService;

    @GetMapping("/oder")
    public String showListBorrow(Model model) {
        model.addAttribute("oders", this.oderService.findAll());
        return "list-borrow";
    }
}
