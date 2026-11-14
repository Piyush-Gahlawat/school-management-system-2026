package com.shiryu.school.repository;

import com.shiryu.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
}