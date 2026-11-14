package com.shiryu.school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class Person extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private boolean isAnonymized = false;

    public void anonymize() {
        this.firstName = "[ERASED]";
        this.lastName = "[ERASED]";
        this.email = "erased-" + this.getId() + "@anonymized.local";
        this.phoneNumber = null;
        this.isAnonymized = true;
    }
}