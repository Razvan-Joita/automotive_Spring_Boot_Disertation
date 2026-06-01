package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.AppointmentDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "vehicle.id", target = "vehicleId")
    AppointmentDTO toDTO(Appointment entity);

    @Mapping(target = "vehicle", ignore = true)
    Appointment toEntity(AppointmentDTO dto);
}