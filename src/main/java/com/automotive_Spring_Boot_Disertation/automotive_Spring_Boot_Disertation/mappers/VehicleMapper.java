package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.VehicleDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(target = "manufacturerId", expression = "java(vehicle.getManufacturer() != null ? vehicle.getManufacturer().getId() : null)")
    VehicleDTO toDTO(Vehicle vehicle);

    @Mapping(target = "manufacturer", ignore = true)
    Vehicle toEntity(VehicleDTO vehicleDTO);
}