package com.example.service;

import com.example.entrity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceDemo implements StudentServiceImpl {
    List<Student> list = new ArrayList<>();

    public StudentServiceDemo() {
        list.add(new Student(1, "a", 20, "xalo@gmail.com", "gialam", "987654321", 1, "c03"));
        list.add(new Student(2, "b", 20, "xalo@gmail.com", "gialam", "987654321", 1, "c03"));
        list.add(new Student(3, "c", 20, "xalo@gmail.com", "gialam", "987654321", 2, "c04"));

    }

    @Override
    public List<Student> getAllStudent() throws SQLException {
        return list;
    }

    @Override
    public Student findById(int id) throws SQLException {
        for (Student stu : list) {
            if (stu.getId() == id) {
                return stu;
            }
        }
        return null;
    }

    @Override
    public boolean addStudent(Student student)throws SQLException {
        for (Student stu : list) {
            if (stu.getId() == student.getId()) {
                return false;
            }
        }
        list.add(student);
        return true;
    }

    @Override
    public boolean editStudent(Student student)throws SQLException {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==student.getId()){
                list.set(i,student);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudent(Student student)throws SQLException {
        for (Student stu : list) {
            if (stu.getId() == student.getId()) {
                return list.remove(student);
            }
        }
        return false;
    }

    @Override
    public List<Student> searchByString(String symbol) throws SQLException{
        return null;
    }
}
