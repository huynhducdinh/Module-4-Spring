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
    public String calculator(Model model, @RequestParam(defaultValue = "0") float numberOne , @RequestParam(defaultValue = "0") float numberTwo, String action) {
        float result;
        switch (action) {
            case "multiplication": {
                result = iCalculatorService.multiplication(numberOne, numberTwo);
                model.addAttribute("action","multiplication");
                model.addAttribute("result", result);
                break;
            }
            case "division": {
                result = iCalculatorService.division(numberOne, numberTwo);
                model.addAttribute("action","division");
                model.addAttribute("result", result);
                break;
            }
            case "addition": {
                result = iCalculatorService.addition(numberOne, numberTwo);
                model.addAttribute("action","addition");
                model.addAttribute("result", result);
                break;
            }
            case "subtraction": {
                result = iCalculatorService.subtraction(numberOne, numberTwo);
                model.addAttribute("action","subtraction");
                model.addAttribute("result", result);
                break;
            }


        }
        model.addAttribute("numberOne",numberOne);
        model.addAttribute("numberTwo", numberTwo);
        return "index";
    }
}
