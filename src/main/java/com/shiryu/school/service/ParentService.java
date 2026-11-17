package com.shiryu.school.service;

import com.shiryu.school.dto.ParentRequest;
import com.shiryu.school.dto.ParentResponse;
import java.util.List;

public interface ParentService {
    ParentResponse createParent(ParentRequest request);
    List<ParentResponse> getAllParents();
    ParentResponse getParentById(Long id);
    void deleteParent(Long id);
}