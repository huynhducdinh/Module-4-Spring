package com.example.bai2.controller;

import com.example.bai2.service.ITuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TuDien {
    @Autowired
    private ITuDienService iTuDienService;
    @GetMapping("/")
    public String home(){
        return "timkiem";
    }

    @PostMapping ("/a")
    public String timKIem(Model model , @RequestParam(value = "english",defaultValue = "0")String english){
       String viet= iTuDienService.tuDien(english);
       model.addAttribute("english",english);
        model.addAttribute("viet",viet);
        return "timkiem";
    }
}
