package com.example.controller;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.SQLException;


@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String showAllStudent(Model model) throws SQLException {
        model.addAttribute("list", studentService.getAllStudent());
        return "/Home";
    }

    @GetMapping("/detail/{id}")
    public String showDetailStudent(@PathVariable int id, Model model) throws SQLException {
        model.addAttribute("student", studentService.findById(id));
        return "/ShowDetailStudent";
    }

    @GetMapping("/create")
    public String createStudent(Model  model) {
        model.addAttribute("student",new Student());
        return "/Create";
    }


    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,int idclass, @RequestParam MultipartFile imgFile) throws IOException {
        studentService.addStudent(student,idclass,imgFile);
        return "redirect:/student";
    }

    @GetMapping("/delete") public String deleteStudent(@ModelAttribute Student student){
        studentService.deleteStudent(student);
        return "redirect:/student";
    }


}
