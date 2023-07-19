package com.example.controller;

import com.example.entity.Product;
import com.example.service.ICartService;
import com.example.service.impl.ProductServiceImpl;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private HttpSession session;

    @GetMapping()
    public String homePage(Model model ,@RequestParam(defaultValue = "0") int page) {
        model.addAttribute("name_client", (String) session.getAttribute("name_user"));
        Page<Product> list=productService.getAllProduct(PageRequest.of(page,5));
        return "home_product";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable int  id, Model model) {
        model.addAttribute("product", productService.finByID(id));
        return "detail_product";
    }
@GetMapping("/addcart/{id}")
    public String addProductToCart(){


        return "redirect:/product";
}

}
