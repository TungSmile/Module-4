package com.example.DAO;
import com.example.entity.Student;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
public class StudentDAO {
    @PersistenceContext
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
        entityManager.persist(student);
    }

    public void editStudent(Student student) {
        entityManager.merge(student);
    }

    public void delete(Student student){
        entityManager.remove(student);
    }
    public List<Student> findByString( String name ){
        String sql= "SELECT s FROM Student s where s.name = :name";
        TypedQuery<Student> query=entityManager.createQuery(sql, Student.class).setParameter("name", name);
        return (List<Student>) query.getResultList();
    }

}
