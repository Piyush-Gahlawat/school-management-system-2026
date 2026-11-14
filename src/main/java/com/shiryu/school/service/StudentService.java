package com.shiryu.school.service;

import com.shiryu.school.dto.StudentRequest;
import com.shiryu.school.dto.StudentResponse;
import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentRequest request);
    List<StudentResponse> getAllStudents();
    StudentResponse getStudentById(Long id);
    void deleteStudent(Long id);
}