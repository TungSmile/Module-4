package com.example.controller;

import com.example.entity.Account;
import com.example.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
@RequestMapping("/login")
public class LoginAPI {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;


    @PostMapping()
    public String getLogin(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getAccountName(), account.getAccountPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token =jwtService.createToken(authentication);
        return token;
    }

}
