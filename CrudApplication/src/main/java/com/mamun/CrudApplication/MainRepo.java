package com.mamun.CrudApplication;

import com.mamun.CrudApplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepo extends JpaRepository<Student, Integer> {
}
