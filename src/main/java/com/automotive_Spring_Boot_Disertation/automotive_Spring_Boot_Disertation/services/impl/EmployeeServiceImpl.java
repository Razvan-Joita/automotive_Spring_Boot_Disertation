package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.EmployeeDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.EmployeeMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Dealership;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Employee;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.DealershipRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.EmployeeRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;
    private final EmployeeMapper mapper;
    private final DealershipRepository dealershipRepository;

    @Override
    @Transactional
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee entity = mapper.toEntity(dto);

        // Map dealership if provided
        if (dto.getDealershipId() != null) {
            Dealership dealership = dealershipRepository.findById(dto.getDealershipId())
                    .orElseThrow(() -> new ResourceNotFoundException("Dealership not found with id: " + dto.getDealershipId()));
            entity.setDealership(dealership);
        }

        return mapper.toDTO(repo.save(entity));
    }

    @Override
    @Transactional
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        entity.setName(dto.getName());      // Use name, not firstName/lastName
        entity.setRole(dto.getRole());      // Use role
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        // Update dealership if provided
        if (dto.getDealershipId() != null) {
            Dealership dealership = dealershipRepository.findById(dto.getDealershipId())
                    .orElseThrow(() -> new ResourceNotFoundException("Dealership not found with id: " + dto.getDealershipId()));
            entity.setDealership(dealership);
        }

        return mapper.toDTO(repo.save(entity));
    }

    @Override
    public EmployeeDTO getById(Long id) {
        return mapper.toDTO(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id)));
    }

    @Override
    public Page<EmployeeDTO> getAll(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDTO);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        repo.deleteById(id);
    }
}