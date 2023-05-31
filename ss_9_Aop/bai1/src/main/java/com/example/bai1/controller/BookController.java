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
    IBorrowService iBorrowService;

    @GetMapping("/book")
    public String listBook(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        Book book = iBookService.findById(id);
        boolean check = iBookService.save(book);
        if (check == false) {
            return "error";
        } else {
            int random;
            boolean flag;
            do {
                random = ThreadLocalRandom.current().nextInt(10000, 999999);
                flag = iBorrowService.checkCodeName(random);
            }while (flag);
            Borrow borrow=new Borrow(random,true,book);
            iBorrowService.saveBook(borrow);
            attributes.addFlashAttribute("mess","Mã sách : "+random);

            return "redirect:/book";
        }
    }
    @GetMapping("/giveBookBack/{codeName}")
    public String giveBook(@PathVariable("codeName") Integer codeName, Model model, RedirectAttributes redirectAttributes){
        boolean check=iBorrowService.checkCodeName(codeName);
        if (check==false){
            return "error";
        }else {
            Borrow borrow=iBorrowService.getByCodeName(codeName);
            borrow.setStatus(false);
            iBorrowService.saveBook(borrow);
            Book book=iBookService.findById(borrow.getBook().getId());
            int quantity = book.getQuantity() + 1;
            book.setQuantity(quantity);
            iBookService.saveBook(book);
            redirectAttributes.addFlashAttribute("check",book.getName());
            return "redirect:/listBorrow";
        }
    }

    @ExceptionHandler(Exception.class)
    public String log() {
        return "error";
    }
}
