package com.example.model.service;

import com.example.model.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccService extends UserDetailsService {
    List<Account> getAll();

    void save(Account account);

    void delete(Account account);

    Account login(String password, String userName);
}
