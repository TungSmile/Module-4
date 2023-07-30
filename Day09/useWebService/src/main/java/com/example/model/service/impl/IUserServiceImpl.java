package com.example.model.service.impl;

import com.example.model.entity.User;
import com.example.model.repository.IUserRepo;
import com.example.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    IUserRepo iUserRepo;

    @Override
    public List<User> getAll() {
        return (List<User>) iUserRepo.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepo.save(user);
    }

    @Override
    public void delete(User user) {
        iUserRepo.delete(user);
    }
}

