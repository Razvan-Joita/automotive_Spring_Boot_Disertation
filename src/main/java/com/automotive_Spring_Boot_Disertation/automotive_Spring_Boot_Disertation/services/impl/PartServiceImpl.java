package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.PartDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.PartMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Part;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.PartRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final PartMapper partMapper;

    @Override
    public PartDTO createPart(PartDTO dto) {
        Part part = partMapper.toEntity(dto);
        return partMapper.toDTO(partRepository.save(part));
    }

    @Override
    public PartDTO getPartById(Long id) {
        return partRepository.findById(id)
                .map(partMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Part not found with id " + id));
    }

    @Override
    public List<PartDTO> getAllParts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return partRepository.findAll(pageable)
                .stream()
                .map(partMapper::toDTO)
                .toList();
    }

    @Override
    public PartDTO updatePart(Long id, PartDTO dto) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part not found with id " + id));
        part.setName(dto.getName());
        part.setPrice(dto.getPrice());
        return partMapper.toDTO(partRepository.save(part));
    }

    @Override
    public void deletePart(Long id) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part not found with id " + id));
        partRepository.delete(part);
    }
}
