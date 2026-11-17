package com.shiryu.school.service;

import com.shiryu.school.dto.StudentRequest;
import com.shiryu.school.dto.StudentResponse;
import com.shiryu.school.entity.Student;
import com.shiryu.school.exception.ResourceNotFoundException;
import com.shiryu.school.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public TeacherServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public StudentResponse createStudent(StudentRequest request) {
        if (studentRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already in use");
        }
        
        Student student = new Student();
        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setEmail(request.email());
        student.setDateOfBirth(request.dateOfBirth());
        student.setEnrollmentYear(request.enrollmentYear());
        
        return StudentResponse.from(studentRepository.save(student));
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + id));
        return StudentResponse.from(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + id));
        
        // GDPR MAGIC: We don't delete, we anonymize!
        student.anonymize();
        studentRepository.save(student);
    }
}