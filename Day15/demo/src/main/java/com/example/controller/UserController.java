package com.example.controller;

import com.example.model.entity.Account;
import com.example.model.service.IAccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IAccService iUserService;


    @GetMapping
    public List<Account> showAll() {
        return iUserService.getAll();
    }

    @PostMapping("/create")
    public void addNew(@RequestBody Account user) {
        iUserService.save(user);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Account user) {
        iUserService.delete(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(HttpServletRequest request) {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");
        Account user1 = iUserService.login(pass, user);

        return new ResponseEntity<>(user1,HttpStatus.OK) ;
    }
}
