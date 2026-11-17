package com.shiryu.school.repository;

import com.shiryu.school.entity.Consent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsentRepository extends JpaRepository<Consent, Long> {
    boolean existsByEmail(String email);
}