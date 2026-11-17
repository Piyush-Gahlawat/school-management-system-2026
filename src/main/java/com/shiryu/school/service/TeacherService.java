package com.shiryu.school.service;

import com.shiryu.school.dto.TeacherRequest;
import com.shiryu.school.dto.TeacherResponse;
import java.util.List;

public interface TeacherService {
    TeacherResponse createTeacher(TeacherRequest request);
    List<TeacherResponse> getAllTeachers();
    TeacherResponse getTeacherById(Long id);
    void deleteTeacher(Long id);
}