package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.ManufacturerDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.ManufacturerMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Manufacturer;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.ManufacturerRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    @Override
    public ManufacturerDTO createManufacturer(ManufacturerDTO manufacturerDto) {
        Manufacturer manufacturer = manufacturerMapper.toEntity(manufacturerDto);
        return manufacturerMapper.toDTO(manufacturerRepository.save(manufacturer));
    }

    @Override
    public ManufacturerDTO getManufacturer(Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found with id: " + id));
        return manufacturerMapper.toDTO(manufacturer);
    }

    @Override
    public Page<ManufacturerDTO> getAllManufacturers(Pageable pageable, String search) {
        Page<Manufacturer> page;
        if (search != null && !search.isEmpty()) {
            page = manufacturerRepository.findByNameContainingIgnoreCase(search, pageable);
        } else {
            page = manufacturerRepository.findAll(pageable);
        }
        return page.map(manufacturerMapper::toDTO);
    }

    @Override
    public ManufacturerDTO updateManufacturer(Long id, ManufacturerDTO manufacturerDto) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found with id: " + id));

        manufacturer.setName(manufacturerDto.getName());
        manufacturer.setCountry(manufacturerDto.getCountry());

        return manufacturerMapper.toDTO(manufacturerRepository.save(manufacturer));
    }

    @Override
    public void deleteManufacturer(Long id) {
        if (!manufacturerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Manufacturer not found with id: " + id);
        }
        manufacturerRepository.deleteById(id);
    }
}