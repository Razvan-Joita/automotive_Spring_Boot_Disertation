package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.WarrantyDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.WarrantyMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Warranty;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.WarrantyRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.WarrantyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository repository;
    private final WarrantyMapper mapper;

    @Override
    public WarrantyDTO create(WarrantyDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public WarrantyDTO getById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));
    }

    @Override
    public Page<WarrantyDTO> getAll(Pageable pageable, String search) {
        Page<Warranty> page;
        if (search != null && !search.isEmpty()) {
            // Assuming you have a search method in repository
            // page = repository.findByVehicleVinContainingIgnoreCase(search, pageable);
            page = repository.findAll(pageable); // Replace with actual search logic
        } else {
            page = repository.findAll(pageable);
        }
        return page.map(mapper::toDTO);
    }

    @Override
    public WarrantyDTO update(Long id, WarrantyDTO dto) {
        Warranty warranty = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));
        warranty.setStartDate(dto.getStartDate());
        warranty.setEndDate(dto.getEndDate());
        return mapper.toDTO(repository.save(warranty));
    }

    @Override
    public void delete(Long id) {
        Warranty warranty = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));
        repository.delete(warranty);
    }
}