package com.shiryu.school.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {
    private String employeeId;
    private String department;
}