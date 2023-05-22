package com.example.bai1.controller;

import com.example.bai1.model.ElectronicMailBoxModel;
import com.example.bai1.service.ElectronicMailBoService;
import com.example.bai1.service.IElectronicMailBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ElectronicMailBoxController {
    @Autowired
    private  IElectronicMailBoService iElectronicMailBoService;
    @GetMapping("/")
    public String viewMailBox (Model model){
        String [] language= new String[]{"English","Vietnamese","Japanese","Chinese"};
        String [] pageSize=new  String[]{ "5","10","15","20","25"};
        ElectronicMailBoxModel electronicMailBoxModel=iElectronicMailBoService.getAll();
        model.addAttribute("language",language);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("electronicMailBoxModel",electronicMailBoxModel);
        return "mailbox";
    }
    @PostMapping("/mail")
    public String Update(@ModelAttribute("mailBox")ElectronicMailBoxModel electronicMailBoxModel ,Model model ){
        iElectronicMailBoService.save(electronicMailBoxModel);
        ElectronicMailBoxModel electronicMailBox= iElectronicMailBoService.update();
        model.addAttribute("electronicMailBox",electronicMailBox);
        return  "update";
    }

}
