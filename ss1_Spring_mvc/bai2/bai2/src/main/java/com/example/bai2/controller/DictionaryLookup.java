package com.example.bai2.controller;

import com.example.bai2.service.IDictionaryLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryLookup {
    @Autowired
    private IDictionaryLookupService iTuDienService;
    @GetMapping("/")
    public String home(){
        return "translate";
    }

    @PostMapping ("/translate")
    public String timKIem(Model model , @RequestParam(value = "english",defaultValue = "0")String english){
       String viet= iTuDienService.dictionaryLookupRepository(english);
       model.addAttribute("english",english);
        model.addAttribute("viet",viet);
        return "translate";
    }
}
