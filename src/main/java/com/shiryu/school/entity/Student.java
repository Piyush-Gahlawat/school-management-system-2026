package com.shiryu.school.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@DiscriminatorValue("STUDENT")
public class Student extends Person {
    private LocalDate dateOfBirth;
    private String enrollmentYear;
}