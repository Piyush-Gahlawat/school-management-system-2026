package com.shiryu.school.repository;

import com.shiryu.school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    boolean existsByEmail(String email);
}