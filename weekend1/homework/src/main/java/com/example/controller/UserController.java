package com.example.controller;

import com.example.entity.User;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private  HttpSession session;

    @PostMapping()
    public String login(String id, String pass) {
        User user=userService.login(id, pass);
        if (user != null) {
            session.setAttribute("name_user",user.getName());
            session.setAttribute("user",user);
            session.setAttribute("id_user",user.getId());
            return "redirect:/product";
        } else{ return "sign_in";}
    }

    @GetMapping("/create")
    public String signUp(Model model) {
        model.addAttribute("user",new User());
        return "sign_up";
    }

    @PostMapping("/create")
    public String signUp(@ModelAttribute User user, @RequestParam MultipartFile fileImg) throws IOException {
        // thiếu valition đợi bổ sung
        userService.addNewUser(user,fileImg);
        return "sign_in";
    }

}
