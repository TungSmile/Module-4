package com.example.service;
import com.example.entrity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentServiceImpl {
    List<Student> getAllStudent()throws SQLException;

    Student findById(int id)throws SQLException;

    boolean addStudent(Student student)throws SQLException;

    boolean editStudent(Student student)throws SQLException;

    boolean deleteStudent(Student student)throws SQLException;

    List<Student> searchByString(String symbol)throws SQLException;
}
