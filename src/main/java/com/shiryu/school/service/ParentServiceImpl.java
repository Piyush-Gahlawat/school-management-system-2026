package com.shiryu.school.service;
import com.shiryu.school.dto.ParentRequest;
import com.shiryu.school.dto.ParentResponse;
import com.shiryu.school.entity.Parent;
import com.shiryu.school.exception.ResourceNotFoundException;
import com.shiryu.school.repository.ParentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    @Transactional
    public ParentResponse createParent(ParentRequest request) {
        Parent parent = new Parent();
        parent.setFirstName(request.firstName());
        parent.setLastName(request.lastName());
        parent.setEmail(request.email());

        return ParentResponse.from(parentRepository.save(parent));

    }
    @Override
    public List<ParentResponse> getAllParents() {
        return parentRepository.findAll().stream()
                .map(ParentResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public ParentResponse getParentById(Long id) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parent not found: " + id));
        return ParentResponse.from(parent);
    }

    @Override
    @Transactional
    public void deleteParent(Long id) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parent not found: " + id));

        // GDPR MAGIC: We don't delete, we anonymize!
        parent.anonymize(); 
        parentRepository.save(parent);
    }
}