package com.example.service.impl;

import com.example.entity.Account;
import com.example.repository.IAccountRepo;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Override
    public List<Account> getAll() {
        return (List<Account>) iAccountRepo.findAll();
    }

    @Override
    public void addNewAcc(Account account) {
        iAccountRepo.save(account);
    }

    @Override
    public void deleteAcc(Account account) {
        iAccountRepo.delete(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.getAccountByAccountName(username);
        List<GrantedAuthority> role = new ArrayList<>();
        role.add(account.getRole());
        return new User(account.getAccountName(),account.getAccountPassword(),role);
    }
}
