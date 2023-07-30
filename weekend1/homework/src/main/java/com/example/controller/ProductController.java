package com.example.controller;

import com.example.entity.Product;
import com.example.service.ICartService;
import com.example.service.ICommentService;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IProductService productService;
    @Autowired
    private HttpSession session;
    @Autowired
    private ICommentService iCommentService;

    @GetMapping()
    public String homePage(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("name_client", session.getAttribute("name_user"));
        Page<Product> list = productService.getAllProduct(PageRequest.of(page, 5));
        model.addAttribute("list", list);
        return "home_product";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.finByID(id));
        model.addAttribute("list", iCommentService.getAllProductFromProduct(id));
        return "detail_product";
    }

    @GetMapping("/addcart")
    public String addProductToCart(@RequestParam int id) {
        iCartService.addProductToCart((Integer) session.getAttribute("id_user"), id);
        return "redirect:/product";
    }

    @PostMapping("/comment")
    public String addCommentToProduct( int id, String comment) {
        iCommentService.addNewComment((Integer) session.getAttribute("id_user"), id, comment);
        return "redirect:/product/"+id;
    }

}
