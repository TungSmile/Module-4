package com.example.DAO;
import com.example.entity.User;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDAO {
    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers() {
        String sql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        return (List<User>) query;
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void editUser(User v) {
        entityManager.merge(v);
    }

    public void deleteUser(User user) {
        entityManager.remove(user);
    }
    public User findById(int id) {
        String queryStr = "SELECT s FROM User s where s.id = :id";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class).setParameter("id", id);
        return query.getSingleResult();
    }

    public User findByLogin(String user,String pass){
        String sql="SELECT u FROM User u WHERE u.username = :id AND u.password = :pass";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        query.setParameter("id",user);
        query.setParameter("pass",pass);
        return query.getSingleResult();
    }
}