package com.example.controller;

import com.example.model.entity.User;
import com.example.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping
    public List<User> showAll() {
        return iUserService.getAll();
    }

    @PostMapping
    public void addNew(@RequestBody User user) {
        iUserService.save(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        iUserService.delete(user);
    }

}
