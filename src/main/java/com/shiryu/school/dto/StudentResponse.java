package com.shiryu.school.dto;

import com.shiryu.school.entity.Student;
import java.time.LocalDate;
public record StudentResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        LocalDate dateOfBirth,
        boolean isAnonymized) {
    public static StudentResponse from(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getDateOfBirth(),
                student.isAnonymized());
    }
}