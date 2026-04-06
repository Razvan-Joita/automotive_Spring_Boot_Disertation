package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.VehicleDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.VehicleMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Vehicle;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.VehicleRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repo;
    private final VehicleMapper mapper;

    @Override
    public VehicleDTO create(VehicleDTO dto) {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public VehicleDTO update(Long id, VehicleDTO dto) {
        Vehicle entity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        entity.setVin(dto.getVin());
        entity.setModel(dto.getModel());
        entity.setYear(dto.getYear());
        return mapper.toDTO(repo.save(entity));
    }

    @Override
    public VehicleDTO getById(Long id) {
        return mapper.toDTO(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found")));
    }

    @Override
    public Page<VehicleDTO> getAll(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDTO);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}