package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.AppointmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppointmentService {
    AppointmentDTO create(AppointmentDTO dto);
    AppointmentDTO update(Long id, AppointmentDTO dto);
    AppointmentDTO getById(Long id);
    Page<AppointmentDTO> getAll(Pageable pageable);
    void delete(Long id);
}