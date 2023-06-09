package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {
    @GetMapping("/")
    public String sandwich(){
        return "index";
    }
    @PostMapping("/spiceList")
    public String showSpice(Model model, @RequestParam("spice")String[] spice){
        model.addAttribute("spice",spice);
        return "index";
    }
}
