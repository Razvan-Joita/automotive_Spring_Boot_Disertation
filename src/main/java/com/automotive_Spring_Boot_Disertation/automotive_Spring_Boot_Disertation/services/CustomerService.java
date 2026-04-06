package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerDTO create(CustomerDTO dto);
    CustomerDTO update(Long id, CustomerDTO dto);
    CustomerDTO getById(Long id);
    Page<CustomerDTO> getAll(Pageable pageable);
    void delete(Long id);
}