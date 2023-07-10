package com.mvc.slack.service;

import com.mvc.slack.model.Student;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        students.add(new Student(1, "sv1", 20, "https://image-us.eva.vn/upload/1-2022/images/2022-02-20/1645325682-ta-xua4-16450861597682099786350.jpg"));
        students.add(new Student(2, "sv2", 21, "https://image-us.eva.vn/upload/1-2022/images/2022-02-20/1645325682-ta-xua6-16450861597751806752053.jpg"));
        students.add(new Student(3, "sv3", 22, "https://vn.blog.kkday.com/wp-content/uploads/chup-anh-dep-bang-dien-thoai-25.jpg"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void editStudents(int id, Student student) {
        int index = findIndexById(id);
        students.set(index, student);
    }

    public void deleteStudent(int id) {
        students.remove(findById(id));
    }

}
