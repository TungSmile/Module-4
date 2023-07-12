package com.example.service;

import com.example.entrity.ConnectJDBC;
import com.example.entrity.Student;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentServiceImpl {

    @Override
    public List<Student> getAllStudent() throws SQLException {
        String sql = "select * from student s join classroom c where s.id_classroom=c.id;";
        List<Student> list = new ArrayList<>();
        try (Statement statement = ConnectJDBC.getConnect().createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int id_classroom = resultSet.getInt("id_classroom");
                String class_name = resultSet.getString("class_name");
                list.add(new Student(id, name, age, email, address, phone, id_classroom, class_name));
            }
            return list;
        }

    }


    @Override
    public Student findById(int id) throws SQLException {
        String sql = "select * from student where id= ? ;";
        try (CallableStatement callableStatement=ConnectJDBC.getConnect().prepareCall(sql)
        ) {

        }

        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        return false;
    }

    @Override
    public boolean editStudent(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }

    @Override
    public List<Student> searchByString(String symbol) {
        return null;
    }
}
