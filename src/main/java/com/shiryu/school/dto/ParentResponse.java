package com.shiryu.school.dto;

import com.shiryu.school.entity.Parent;
public record ParentResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        boolean isAnonymized) {
    public static ParentResponse from(Parent parent) {
        return new ParentResponse(
                parent.getId(),
                parent.getFirstName(),
                parent.getLastName(),
                parent.getEmail(),
                parent.isAnonymized());
    }
}