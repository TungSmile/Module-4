package com.example.dao;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDAO {
    @Autowired
    EntityManager entityManager;

    public List<User> getAllUser() {
        String sql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        return (List<User>) query.getResultList();
    }

    public User findByID(int id) {
        String sql = "SELECT u FROM User u where u.id = :id";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class).setParameter("id", id);
        return query.getSingleResult();
    }

    public User signIn(String id, String pass) {
        String sql = "SELECT u FROM User u WHERE u.username = :id AND u.password = :pass";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class).setParameter("id", id);
        return query.getSingleResult();
    }

    public void signUp(User user) {
        entityManager.persist(user);
    }

    public void editUser(User user) {
        entityManager.merge(user);
    }

    public void deleteUser(User user) {
        entityManager.remove(user);
    }
}
