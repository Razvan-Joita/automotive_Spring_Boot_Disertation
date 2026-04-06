package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.PartDTO;

import java.util.List;

public interface PartService {
    PartDTO createPart(PartDTO dto);
    PartDTO getPartById(Long id);
    List<PartDTO> getAllParts(int page, int size);
    PartDTO updatePart(Long id, PartDTO dto);
    void deletePart(Long id);
}