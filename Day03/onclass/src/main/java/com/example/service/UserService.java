package com.example.service;

import com.example.DAO.StudentDAO;
import com.example.DAO.UserDAO;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private StudentDAO studentDAO;

    public List<User> getAllUser() {
        return userDAO.getAllUsers();
    }

    public void addUser(User user, int idStudent) {
        user.setStudent(studentDAO.findById(idStudent));
        userDAO.addUser(user);
    }

    public void editUser(User user) {
        userDAO.editUser(user);

    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public User signIn(String user, String pass) {
        return userDAO.findByLogin(user, pass);
    }
}
