package com.example.model.service.impl;

import com.example.model.entity.Account;
import com.example.model.repository.IAccRepo;
import com.example.model.service.IAccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IAccServiceImpl implements IAccService {
    @Autowired
    IAccRepo iUserRepo;

    @Override
    public List<Account> getAll() {
        return (List<Account>) iUserRepo.findAll();
    }

    @Override
    public void save(Account account) {
        iUserRepo.save(account);
    }

    @Override
    public void delete(Account account) {
        iUserRepo.delete(account);
    }

    @Override
    public Account login(String userName, String password) {
        return iUserRepo.findUserByPasswordAndId_user(userName, password);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iUserRepo.getAccountByUserName(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUserName(), account.getPassword(), roles);
    }
}

