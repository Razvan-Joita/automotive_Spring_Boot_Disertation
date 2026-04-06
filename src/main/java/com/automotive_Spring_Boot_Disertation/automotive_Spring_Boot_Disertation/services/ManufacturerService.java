package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.ManufacturerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManufacturerService {
    ManufacturerDTO createManufacturer(ManufacturerDTO manufacturerDto);
    ManufacturerDTO getManufacturer(Long id);
    Page<ManufacturerDTO> getAllManufacturers(Pageable pageable, String search); // Fixed signature
    ManufacturerDTO updateManufacturer(Long id, ManufacturerDTO manufacturerDto);
    void deleteManufacturer(Long id);
}