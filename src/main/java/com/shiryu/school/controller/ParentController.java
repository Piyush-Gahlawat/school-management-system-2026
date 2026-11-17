package com.shiryu.school.controller;

import com.shiryu.school.dto.ParentRequest;
import com.shiryu.school.dto.ParentResponse;
import com.shiryu.school.service.ParentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parents")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping
    public ResponseEntity<ParentResponse> createParent(@Valid @RequestBody ParentRequest request) {
        return new ResponseEntity<>(parentService.createParent(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ParentResponse>> getAllParents() {
        return ResponseEntity.ok(parentService.getAllParents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentResponse> getParentById(@PathVariable Long id) {
        return ResponseEntity.ok(parentService.getParentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return ResponseEntity.ok("Parent record anonymized successfully (GDPR Compliance)");
    }
}