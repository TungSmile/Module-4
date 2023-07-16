package com.example.service;

import com.example.entity.Student;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface StudentServiceImpl {
    List<Student> getAllStudent();

    Student findById(int id);

    void addStudent(Student student, int idClass, MultipartFile imgFile);

    void editStudent(Student student);

    void deleteStudent(Student student);

    List<Student> searchByString(String symbol);
}
