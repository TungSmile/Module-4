package com.example.controller;

import com.example.entity.User;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private HttpSession session;

    @GetMapping()
    public String welcome() {
        return "sign_in";
    }

    @PostMapping()
    public String login(String id, String pass) {
        User user = userService.login(id, pass);
        if (user.getRole().equals("admin")) return "home";
        if (user != null) {
            session.setAttribute("name_user", user.getName());
            session.setAttribute("user", user);
            session.setAttribute("id_user", user.getId());
            return "redirect:/product";
        } else {
            return "sign_in";
        }
    }

    @GetMapping("/create")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/create")
    public String signUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam MultipartFile fileImg) throws IOException {
        if (bindingResult.hasErrors()){
            return "sign_up";
        }else {
            userService.addNewUser(user, fileImg);
            return "sign_in";
        }

    }

}
