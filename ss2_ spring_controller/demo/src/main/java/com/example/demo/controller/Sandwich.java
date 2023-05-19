package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {
    @GetMapping("/")
    public String sandwich(){
        return "index";
    }
    @PostMapping("/show")
    public String showSpice(Model model, @RequestParam("spice")String[] spice){
        model.addAttribute("spice",spice);
        return "index";
    }
}
