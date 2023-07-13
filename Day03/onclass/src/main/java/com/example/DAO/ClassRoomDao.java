package com.example.DAO;

import com.example.entity.Student;
import com.example.entity.classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
@Component
public class ClassRoomDao {
    @Autowired
    EntityManager entityManager;
    public classroom findById(int id) {
        String queryStr = "SELECT s FROM classroom s where s.id = :id";
        TypedQuery<classroom> query = entityManager.createQuery(queryStr, classroom.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
