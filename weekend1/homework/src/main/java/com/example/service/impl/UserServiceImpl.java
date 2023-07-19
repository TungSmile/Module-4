package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.IUserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepo;

    @Override
    public List<User> getAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void edit(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public User finByID(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User login(String id, String pass) {
        return userRepo.login(id, pass);
    }

    @Override
    public void addNewUser(User e, MultipartFile file) throws IOException {
        String nameFile = file.getOriginalFilename();
        file.transferTo(new File("D:\\Module 4\\weekend1\\homework\\src\\main\\webapp\\img"+nameFile));
        e.setImg("/img/"+nameFile);
        userRepo.save(e);
    }


}
