package com.example.service;

import com.example.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    List<Account> getAll();
    void addNewAcc(Account account);
    void deleteAcc(Account account);

}
