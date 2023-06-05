package com.example.demo.controller;

import com.example.demo.model.Email;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
    @Autowired
    private EmailService emailService;
    @GetMapping("/")
    public String form(){
        return "footer";
    }
    @PostMapping("/home")
    public String sendMail(@ModelAttribute("email") Email email) {
        emailService.sendEmail(email);
        return "footer";
    }
}
