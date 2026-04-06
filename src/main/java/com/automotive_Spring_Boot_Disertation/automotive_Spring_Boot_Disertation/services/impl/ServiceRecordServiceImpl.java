package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.ServiceRecordDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.ServiceRecordMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Employee;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Part;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.ServiceRecord;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Vehicle;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.EmployeeRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.PartRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.ServiceRecordRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.VehicleRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.ServiceRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceRecordServiceImpl implements ServiceRecordService {

    private final ServiceRecordRepository repository;
    private final ServiceRecordMapper mapper;
    private final VehicleRepository vehicleRepository;
    private final EmployeeRepository employeeRepository;
    private final PartRepository partRepository;

    @Override
    @Transactional
    public ServiceRecordDTO createServiceRecord(ServiceRecordDTO dto) {
        log.info("Creating new service record");

        ServiceRecord record = mapper.toEntity(dto);

        // Map vehicle
        if (dto.getVehicleId() != null) {
            Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + dto.getVehicleId()));
            record.setVehicle(vehicle);
        }

        // Map mechanic (employee)
        if (dto.getMechanicId() != null) {
            Employee mechanic = employeeRepository.findById(dto.getMechanicId())
                    .orElseThrow(() -> new ResourceNotFoundException("Mechanic not found with id: " + dto.getMechanicId()));
            record.setMechanic(mechanic);
        }

        // Map parts
        if (dto.getPartIds() != null && !dto.getPartIds().isEmpty()) {
            List<Part> parts = partRepository.findAllById(dto.getPartIds());
            record.setParts(parts);
        }

        ServiceRecord saved = repository.save(record);
        log.info("Service record created with id: {}", saved.getId());
        return mapper.toDTO(saved);
    }

    @Override
    public ServiceRecordDTO getServiceRecord(Long id) {
        log.debug("Fetching service record with id: {}", id);
        ServiceRecord record = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceRecord not found with id: " + id));
        return mapper.toDTO(record);
    }

    @Override
    public Page<ServiceRecordDTO> getAllServiceRecords(Pageable pageable, String search) {
        log.debug("Fetching all service records with search: {}", search);
        Page<ServiceRecord> page;
        if (search != null && !search.isEmpty()) {
            page = repository.findByDescriptionContainingIgnoreCase(search, pageable);
        } else {
            page = repository.findAll(pageable);
        }
        return page.map(mapper::toDTO);
    }

    @Override
    @Transactional
    public ServiceRecordDTO updateServiceRecord(Long id, ServiceRecordDTO dto) {
        log.info("Updating service record with id: {}", id);

        ServiceRecord record = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceRecord not found with id: " + id));

        record.setDescription(dto.getDescription());
        record.setDate(dto.getDate());

        // Update vehicle
        if (dto.getVehicleId() != null) {
            Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + dto.getVehicleId()));
            record.setVehicle(vehicle);
        } else {
            record.setVehicle(null);
        }

        // Update mechanic
        if (dto.getMechanicId() != null) {
            Employee mechanic = employeeRepository.findById(dto.getMechanicId())
                    .orElseThrow(() -> new ResourceNotFoundException("Mechanic not found with id: " + dto.getMechanicId()));
            record.setMechanic(mechanic);
        } else {
            record.setMechanic(null);
        }

        // Update parts
        if (dto.getPartIds() != null) {
            List<Part> parts = partRepository.findAllById(dto.getPartIds());
            record.setParts(parts);
        } else {
            record.getParts().clear();
        }

        ServiceRecord updated = repository.save(record);
        log.info("Service record updated with id: {}", updated.getId());
        return mapper.toDTO(updated);
    }

    @Override
    public void deleteServiceRecord(Long id) {
        log.info("Deleting service record with id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ServiceRecord not found with id: " + id);
        }
        repository.deleteById(id);
    }
}