package com.example.DAO;

import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class StudentDAO {
    @Autowired
    EntityManager entityManager;


    public List<Student> getAllStudent() {
        String sql = "SELECT s FROM Student s";
        TypedQuery<Student> query = entityManager.createQuery(sql, Student.class);
        return (List<Student>) query.getResultList();
    }

    public Student findById(int id) {
        String queryStr = "SELECT s FROM Student s where s.id = :id";
        TypedQuery<Student> query = entityManager.createQuery(queryStr, Student.class).setParameter("id", id);
        return query.getSingleResult();
    }

    public void addStudent(Student student) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(student);
        txn.commit();
    }

    public void editStudent(Student student) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(student);
        txn.commit();
    }

    public void delete(Student student){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(student);
        txn.commit();
    }
}
