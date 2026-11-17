package com.shiryu.school.dto;

import com.shiryu.school.entity.Teacher;
public record TeacherResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String department,
        boolean isAnonymized) {
    public static TeacherResponse from(Teacher teacher) {
        return new TeacherResponse(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getEmail(),
                teacher.getDepartment(),
                teacher.isAnonymized()
        );
    }
}