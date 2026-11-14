package com.shiryu.school.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parents")
@Getter
@Setter
@DiscriminatorValue("PARENT")
public class Parent extends Person {
    private String occupation;
    private String relationshipToStudent;
}