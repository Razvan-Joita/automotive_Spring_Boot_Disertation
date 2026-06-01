package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.InvoiceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {
    InvoiceDTO create(InvoiceDTO dto);
    InvoiceDTO update(Long id, InvoiceDTO dto);
    InvoiceDTO getById(Long id);
    Page<InvoiceDTO> getAll(Pageable pageable);
    void delete(Long id);
}