package com.example.bai1.controller;

import com.example.bai1.service.IChuyenDoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UngDungChuyenDoiTienTe {
    @Autowired
    private  IChuyenDoiService iChuyenDoiService;
    @GetMapping("/")
    public String ungDung(Model model, @RequestParam (value = "usd",defaultValue = "0")float usd,@RequestParam(value = "vnd",defaultValue = "0")float vnd){
       long result= (long) iChuyenDoiService.chuyenDoi(usd,vnd);
        model.addAttribute("result",result);
        model.addAttribute("usd",usd);
        return "chuyendoi";
    }

}
