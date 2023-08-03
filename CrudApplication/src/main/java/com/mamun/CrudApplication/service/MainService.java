package com.mamun.CrudApplication.service;

import com.mamun.CrudApplication.model.Student;

import java.util.List;

public interface MainService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(int id);

    Student updateStudent(Student student);

    void deleteStudent(int id);


}
