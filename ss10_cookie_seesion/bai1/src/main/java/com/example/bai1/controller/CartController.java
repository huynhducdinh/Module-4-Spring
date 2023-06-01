package com.example.bai1.controller;


import com.example.bai1.model.Cart;
import com.example.bai1.model.ProductShopp;
import com.example.bai1.serivce.ICartService;
import com.example.bai1.serivce.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@SessionAttributes("cart")
@RequestMapping("shopping-cart")
public class CartController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    ICartService iCartService;

    @GetMapping("/views")
    public String getAllList(@SessionAttribute("cart") Map<Integer,Cart> list, Model model) {
        model.addAttribute("cart",list);
        model.addAttribute("cartMap",iCartService.getAll());
        model.addAttribute("totalSum",iCartService.getAmount());

        return "card";

    }
//thêm vào giỏ hàng
    @GetMapping("add/{id}")
    public String addCart(@PathVariable("id") Integer id) {
        ProductShopp productShopp = iProductService.findByIdProduct(id);
        if (productShopp != null) {
            Cart cart = new Cart();
            cart.setId(productShopp.getId());
            cart.setName(productShopp.getName());
            cart.setPrice(productShopp.getPrice());
            cart.setImage(productShopp.getImage());
            cart.setQuantity(1);
            iCartService.add(cart);
        }
        return "redirect:/shopping-cart/views";
    }
    @GetMapping("delete/{id}")
    public String deleteCart(@PathVariable("id")Integer id){
        iCartService.delete(id);
        return "redirect:/shopping-cart/views";
    }
//    xáo tất cả
    @GetMapping("/clear")
    public String clearCart(){
        iCartService.clear();
        return "redirect:/shopping-cart/views";
    }
    @PostMapping("/update")
        public String update(@RequestParam("id") Integer id,@RequestParam("quantity")Integer quantity){
        iCartService.update(id,quantity);
        return "redirect:/shopping-cart/views";

    }

}
