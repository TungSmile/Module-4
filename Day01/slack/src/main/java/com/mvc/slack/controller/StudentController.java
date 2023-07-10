package com.mvc.slack.controller;

import com.mvc.slack.model.Student;
import com.mvc.slack.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    StudentService stuSer;

    @GetMapping("/home")
    public String showStudent(Model model) {
        model.addAttribute("students", stuSer.getStudents());
        return "Home";
    }

    // chỉ có kiểu dữ liệu đối tượng mới cần dùng model hứng còn nguyên thủy thì ko
    @GetMapping("/edit")
    public String pushToEdit(int id, Model model) {
        model.addAttribute("student", stuSer.findById(id));
        return "Edit";
    }

    // Model khi nhận các tham số giống với class đc set up sẽ tự tạo đối tượng amazing :>
    @PostMapping("/edit")
    public String editStudent(@ModelAttribute Student student) {
        stuSer.editStudents(student.getId(), student);
        return "redirect:/home";
    }
    // dùng redirect để dispather chuyển sang servlet thay vì jsp

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id){
        stuSer.deleteStudent(id);
        return "redirect:/home";
    }
}
