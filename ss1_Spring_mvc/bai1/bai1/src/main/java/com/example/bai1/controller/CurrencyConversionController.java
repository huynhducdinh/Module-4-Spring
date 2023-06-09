package com.example.bai1.controller;

import com.example.bai1.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @Autowired
    private ICurrencyConversionService iCurrencyConversionService;
    @GetMapping("/")
    public String currencyConversion(Model model, @RequestParam (value = "usd",defaultValue = "0")float usd,@RequestParam(value = "vnd",defaultValue = "0")float vnd){
       float result=  iCurrencyConversionService.convert(usd,vnd);
        model.addAttribute("result",result);
        model.addAttribute("usd",usd);
        return "convert";
    }

}
