package com.example.bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AuthenticationController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "accuracy/login";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "accuracy/logoutSuccessfulPage";
    }
}
