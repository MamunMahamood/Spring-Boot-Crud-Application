package com.mamun.CrudApplication.service;

import com.mamun.CrudApplication.MainRepo;
import com.mamun.CrudApplication.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImp implements MainService{
    @Autowired
    MainRepo mr;
    @Override
    public List<Student> getAllStudents() {
        return mr.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return mr.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return mr.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return mr.save(student);
    }

    @Override
    public void deleteStudent(int id) {
         mr.deleteById(id);
    }
}
