package com.mamun.CrudApplication.controller;

import com.mamun.CrudApplication.MainRepo;
import com.mamun.CrudApplication.model.Student;
import com.mamun.CrudApplication.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MainService ms;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/form")
    public String form(){
        return "form";
    }
    @PostMapping("/display")
    public String display(@ModelAttribute Student student){
        //ModelAndView mv = new ModelAndView();

        ms.saveStudent(student);

        return "redirect:/display";
    }

    @GetMapping("/display")
    public String showAllStudents(Model model){
        model.addAttribute("stu", ms.getAllStudents());
        return "display";
    }
    @GetMapping("/display1")
    public String display(){
        return "redirect:/display";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model){
        model.addAttribute("stu",ms.getStudentById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute Student student, Model model){
        Student existingStudent = ms.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFname(student.getFname());
        existingStudent.setLname(student.getLname());
        existingStudent.setDept(student.getDept());
        existingStudent.setEmail(student.getEmail());

        ms.updateStudent(existingStudent);
        return "redirect:/display";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){

        ms.deleteStudent(id);
        return "redirect:/display";

    }


}
