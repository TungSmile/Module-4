package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controllerdemo {
    @RequestMapping("home")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }

}
