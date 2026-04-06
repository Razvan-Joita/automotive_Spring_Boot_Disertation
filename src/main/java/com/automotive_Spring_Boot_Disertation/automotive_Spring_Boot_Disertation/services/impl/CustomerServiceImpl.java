package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.CustomerDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.CustomerMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Customer;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.CustomerRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repo;
    private final CustomerMapper mapper;

    @Override
    public CustomerDTO create(CustomerDTO dto) {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO dto) {
        Customer entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        return mapper.toDTO(repo.save(entity));
    }

    @Override
    public CustomerDTO getById(Long id) {
        return mapper.toDTO(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
    }

    @Override
    public Page<CustomerDTO> getAll(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDTO);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}