package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.DealershipDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.DealershipMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Dealership;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.DealershipRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.DealershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealershipServiceImpl implements DealershipService {

    private final DealershipRepository repository;
    private final DealershipMapper mapper;

    @Override
    public DealershipDTO create(DealershipDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public DealershipDTO getById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Dealership not found"));
    }

    @Override
    public List<DealershipDTO> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size))
                .stream().map(mapper::toDTO).toList();
    }

    @Override
    public DealershipDTO update(Long id, DealershipDTO dto) {
        Dealership dealership = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dealership not found"));
        dealership.setName(dto.getName());
        dealership.setLocation(dto.getLocation());
        return mapper.toDTO(repository.save(dealership));
    }

    @Override
    public void delete(Long id) {
        Dealership dealership = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dealership not found"));
        repository.delete(dealership);
    }
}