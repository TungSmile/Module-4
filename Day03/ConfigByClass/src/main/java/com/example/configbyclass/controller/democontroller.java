package com.example.configbyclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class democontroller {
    @GetMapping("demo")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("/demo");
        return modelAndView;
    }
}
