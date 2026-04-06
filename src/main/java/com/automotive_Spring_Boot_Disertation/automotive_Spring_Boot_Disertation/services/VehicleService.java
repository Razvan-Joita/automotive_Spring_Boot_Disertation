package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.VehicleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService {

    VehicleDTO create(VehicleDTO dto);

    VehicleDTO update(Long id, VehicleDTO dto);

    VehicleDTO getById(Long id);

    Page<VehicleDTO> getAll(Pageable pageable);

    void delete(Long id);
}