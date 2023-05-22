package com.example.bai2.controller;

import com.example.bai2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("calculator")
    public String calculator(Model model, @RequestParam(defaultValue = "0") Float numberOne, @RequestParam(defaultValue = "0") Float numberTwo, String action) {
        Float result = iCalculatorService.calculateResult(numberOne, numberTwo, action);
        model.addAttribute("numberOne", numberOne);
        model.addAttribute("numberTwo", numberTwo);
        model.addAttribute("result",result);
        return "index";
    }
}