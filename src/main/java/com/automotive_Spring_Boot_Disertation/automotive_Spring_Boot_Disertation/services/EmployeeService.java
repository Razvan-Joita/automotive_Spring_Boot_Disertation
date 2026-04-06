package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    EmployeeDTO create(EmployeeDTO dto);
    EmployeeDTO update(Long id, EmployeeDTO dto);
    EmployeeDTO getById(Long id);
    Page<EmployeeDTO> getAll(Pageable pageable);
    void delete(Long id);
}