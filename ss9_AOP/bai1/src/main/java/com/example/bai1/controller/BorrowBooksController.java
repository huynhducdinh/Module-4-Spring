package com.example.bai1.controller;

import com.example.bai1.model.Book;

import com.example.bai1.model.Order;
import com.example.bai1.service.IBookService;

import com.example.bai1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BorrowBooksController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService oderService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "/list";
    }

    @GetMapping("/info/{id}")
    public String showOder(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        if (book.getQuantity() == 0) {
return "error";
        } else {
            model.addAttribute("book", book);
            return "list-borrow";
        }
    }

    @PostMapping("/borrow")
    public String OderBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);

        String loanCode  = oderService.findByCode();
        Order oder = new Order(loanCode, book.getId());
        oderService.save(oder);

        redirectAttributes.addFlashAttribute("msg", "bạn đã mượn thành công sách: " + book.getName() + " Mã mượn sách là: " + loanCode);
        return "redirect:/";
    }

    @GetMapping("/pay_book")
    public String showFormPay() {
        return "/pay";
    }

    @PostMapping("/pay")
    public String getPayBook(@RequestParam String code, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Đã trả sách thành công! " );
        return "redirect:/";
    }




}

//    @ExceptionHandler(BookException.class)
//    public String showError() {
//        return "/error";
//    }



