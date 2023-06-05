package com.example.demo.controller;

import com.example.demo.model.Email;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {

    @Autowired
    private EmailService emailService;
    @PostMapping("/home")
    public String sendMail(@RequestParam("email") Email email) {
        emailService.sendEmail(email);
        return "footer";
    }
}
