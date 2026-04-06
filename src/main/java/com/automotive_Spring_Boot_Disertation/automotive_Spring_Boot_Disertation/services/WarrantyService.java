package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.WarrantyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WarrantyService {
    WarrantyDTO create(WarrantyDTO dto);
    WarrantyDTO getById(Long id);
    Page<WarrantyDTO> getAll(Pageable pageable, String search);
    WarrantyDTO update(Long id, WarrantyDTO dto);
    void delete(Long id);
}