package com.shiryu.school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
public class AuditLog extends BaseEntity {

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String action; 

    @Column(nullable = false)
    private String targetEntity; 

    private Long targetId;
}