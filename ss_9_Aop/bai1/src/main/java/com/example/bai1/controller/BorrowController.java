package com.example.bai1.controller;

import com.example.bai1.model.Borrow;
import com.example.bai1.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BorrowController {
    @Autowired
  private   IBorrowService iBorrowService;
    @GetMapping("/listBorrow")
    public String listBorrow(Model model){
        List<Borrow> borrowList=iBorrowService.findAll();
        model.addAttribute("borrowList",borrowList);
        return "borrow";
    }
}
