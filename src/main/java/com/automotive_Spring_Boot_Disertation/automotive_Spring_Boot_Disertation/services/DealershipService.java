package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.DealershipDTO;

import java.util.List;

public interface DealershipService {
    DealershipDTO create(DealershipDTO dto);
    DealershipDTO getById(Long id);
    List<DealershipDTO> getAll(int page, int size);
    DealershipDTO update(Long id, DealershipDTO dto);
    void delete(Long id);
}