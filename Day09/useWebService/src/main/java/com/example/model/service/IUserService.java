package com.example.model.service;

import com.example.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    void save(User user);

    void delete(User user);

}
