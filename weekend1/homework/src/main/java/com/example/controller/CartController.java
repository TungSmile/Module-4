package com.example.controller;

import com.example.entity.Product;
import com.example.entity.User;
import com.example.service.ICartService;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService iCartService;
    @Autowired
    private HttpSession session;
    @Autowired
    IProductService iProductService;

    @GetMapping()
    public String showCart(Model model) {
        int id_user = (int) session.getAttribute("id_user");
        model.addAttribute("list", iCartService.findProductsById(id_user));
        return "cart_product";
    }

    @GetMapping("/{id}")
    public String addProductToCart(@PathVariable int id) {
        int id_user= (int) session.getAttribute("id_user");
        Product product=iProductService.finByID(id);

        return "redirect:/product";
    }
}
