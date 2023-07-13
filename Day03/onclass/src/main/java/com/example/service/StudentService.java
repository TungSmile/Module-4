package com.example.service;

import com.example.DAO.ClassRoomDao;
import com.example.DAO.StudentDAO;
import com.example.entity.Student;
import com.example.entity.classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class StudentService implements StudentServiceImpl {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    ClassRoomDao classRoomDao;

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();

    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);

    }

    @Override
    public void addStudent(Student student, int idClass, MultipartFile imgFile) {
        String nameFile = imgFile.getOriginalFilename();
        try {
            imgFile.transferTo(new File(fileUpload + nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        student.setImg(fileUpload + nameFile);
        classroom classroom = classRoomDao.findById(idClass);
        student.setclassroom(classroom);
        studentDAO.addStudent(student);
    }

    @Override
    public void editStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public List<Student> searchByString(String symbol) {
        return null;
    }
}
