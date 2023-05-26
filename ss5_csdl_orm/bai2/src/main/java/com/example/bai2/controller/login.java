package com.example.bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {
    @GetMapping("/")
    public String login(){
        return "login";
    }
}
