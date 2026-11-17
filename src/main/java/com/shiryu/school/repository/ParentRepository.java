package com.shiryu.school.repository;

import com.shiryu.school.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParentRepository extends JpaRepository<Parent, Long> {
    boolean existsByEmail(String email);
}