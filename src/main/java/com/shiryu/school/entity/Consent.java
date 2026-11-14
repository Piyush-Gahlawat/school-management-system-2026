package com.shiryu.school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "consents")
@Getter
@Setter
public class Consent extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(nullable = false)
    private String consentType;

    @Column(nullable = false)
    private boolean isGranted;

    @Column(nullable = false)
    private LocalDateTime grantedAt;

    private String ipAddress;
}