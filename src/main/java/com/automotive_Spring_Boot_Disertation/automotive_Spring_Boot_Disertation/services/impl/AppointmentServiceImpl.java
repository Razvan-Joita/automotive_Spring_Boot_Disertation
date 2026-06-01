package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.AppointmentDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.AppointmentMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Appointment;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Vehicle;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.AppointmentRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.VehicleRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final VehicleRepository vehicleRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public AppointmentDTO create(AppointmentDTO dto) {

        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        Appointment appointment = appointmentMapper.toEntity(dto);
        appointment.setVehicle(vehicle);

        return appointmentMapper.toDTO(
                appointmentRepository.save(appointment)
        );
    }

    @Override
    public AppointmentDTO update(Long id, AppointmentDTO dto) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));

        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        appointment.setDate(dto.getDate());
        appointment.setVehicle(vehicle);

        return appointmentMapper.toDTO(
                appointmentRepository.save(appointment)
        );
    }

    @Override
    public AppointmentDTO getById(Long id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));

        return appointmentMapper.toDTO(appointment);
    }

    @Override
    public Page<AppointmentDTO> getAll(Pageable pageable) {

        return appointmentRepository
                .findAll(pageable)
                .map(appointmentMapper::toDTO);
    }

    @Override
    public void delete(Long id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));

        appointmentRepository.delete(appointment);
    }
}