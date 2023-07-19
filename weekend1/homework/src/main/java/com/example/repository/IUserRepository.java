package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends CrudRepository<User,Integer> {
    // generic là entity và kiểu dữ liệu primary key
    @Query("SELECT u FROM User u WHERE u.username = :id and u.password = :pass")
    User login(@Param("id")String id, @Param("pass")String pass);
    // tạo câu query riêng
}
