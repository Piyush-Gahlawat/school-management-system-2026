package com.shiryu.school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course extends ResourceItem {
    private String courseCode;
    private Integer credits;
}