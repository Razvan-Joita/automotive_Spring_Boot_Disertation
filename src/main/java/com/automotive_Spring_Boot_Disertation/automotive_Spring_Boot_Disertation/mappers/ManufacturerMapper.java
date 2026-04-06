package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.ManufacturerDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Manufacturer;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {

    @Mapping(target = "vehicleIds", source = "vehicles", qualifiedByName = "vehiclesToIds")
    ManufacturerDTO toDTO(Manufacturer manufacturer);

    @Mapping(target = "vehicles", ignore = true)
    Manufacturer toEntity(ManufacturerDTO manufacturerDTO);

    @Named("vehiclesToIds")
    default List<Long> vehiclesToIds(List<Vehicle> vehicles) {
        if (vehicles == null) {
            return Collections.emptyList();
        }
        return vehicles.stream()
                .map(Vehicle::getId)
                .collect(Collectors.toList());
    }
}