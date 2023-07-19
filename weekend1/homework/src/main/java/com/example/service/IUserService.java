package com.example.service;
import com.example.entity.User;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface IUserService {
    List<User> getAll();

    void save(User e);

    void edit(User e);

    void delete(User e);

    User finByID(int id);

    User login(String id,String pass);

    void addNewUser(User e , MultipartFile file) throws IOException;

}
