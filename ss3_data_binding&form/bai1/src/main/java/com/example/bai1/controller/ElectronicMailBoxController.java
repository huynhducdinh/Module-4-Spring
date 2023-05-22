package com.example.bai1.controller;

import com.example.bai1.model.ElectronicMailBoxModel;
import com.example.bai1.service.ElectronicMailBoService;
import com.example.bai1.service.IElectronicMailBoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;

@Controller

public class ElectronicMailBoxController {
    private IElectronicMailBoService iElectronicMailBoService=new ElectronicMailBoService();
    @GetMapping("/")
    public String viewMailBox (Model model){
        String [] language= new String[]{"English","Vietnamese","Japanese","Chinese"};
        String [] pageSize=new  String[]{ "5","10","15","20","25"};
//        Boolean checkSpamsFilter;

        model.addAttribute("language",language);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("mailBox",new ElectronicMailBoxModel());
        return "mailbox";
    }
    @PostMapping("/mailbox")
    public String Edit(@ModelAttribute("mailBox")ElectronicMailBoxModel electronicMailBoxModel, BindingResult bindingResult ){
      ElectronicMailBoxModel electronicMailBox =new ElectronicMailBoxModel();
     return  "mailbox";
    }

}
