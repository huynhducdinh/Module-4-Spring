package com.example.bai1.controller;

import com.example.bai1.model.Book;
import com.example.bai1.model.Borrow;
import com.example.bai1.service.IBookService;
import com.example.bai1.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowService iBorrowService;

    @GetMapping("/book")
    public String listBook(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        Book book1 = iBookService.findById(id);
        book1.setQuantity(book1.getQuantity() - 1);
        iBookService.save(book1);
        int codeName;
        List<Borrow> borrows = iBorrowService.findAll();
        codeName = iBorrowService.checkCode(borrows);
        Borrow borrow1 = new Borrow(codeName, book1);
        iBorrowService.save(borrow1);
        model.addAttribute("rentCode", borrow1.getCodeName());
        attributes.addFlashAttribute("mess", "Mã sách : " + borrow1.getCodeName());
        return "redirect:/book";
    }

    @GetMapping("/giveBookBack/{codeName}")
    public String giveBook(@PathVariable("codeName") Integer codeName, RedirectAttributes redirectAttributes) {
        Borrow bookRenting = iBorrowService.checkCodeName(codeName);
        Book book = bookRenting.getBook();
        book.setQuantity(book.getQuantity() + 1);
        iBookService.save(book);
        iBorrowService.getByCodeName(codeName);
        redirectAttributes.addFlashAttribute("check", book.getName());
        return "redirect:/listBorrow";

    }

    @ExceptionHandler(Exception.class)
    public String log() {
        return "error";
    }
}
