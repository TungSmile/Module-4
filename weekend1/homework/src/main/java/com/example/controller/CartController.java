package com.example.controller;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.service.ICartService;
import com.example.service.IInvoiceService;
import com.example.service.IProductService;
import com.example.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService iCartService;
    @Autowired
    private HttpSession session;
    @Autowired
    IProductService iProductService;
    @Autowired
    IInvoiceService iInvoiceService;

    @GetMapping()
    public ModelAndView showCart() {
        int id_user = (int) session.getAttribute("id_user");
        Cart cart= iCartService.findByIDUser(id_user);
        List<Product> productList = cart.getProduct();
        ModelAndView modelAndView = new ModelAndView("cart_product");
        modelAndView.addObject("list",productList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String addProductToCart(@PathVariable int id) {
        int id_user= (int) session.getAttribute("id_user");
        iCartService.addProductToCart(id_user,id);
        return "redirect:/product";
    }

    @GetMapping("/remove/{id}")public String removeProductOnCart(@PathVariable int id){
        int id_user= (int) session.getAttribute("id_user");
        iCartService.removeProductOnCart(id_user,id);
        return "redirect:/cart";
    }
    @GetMapping("/buy")
    public String changeCartToInVoice(){

        return "redirect:/product";
    }
}
