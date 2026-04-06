package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.WarrantyDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Warranty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WarrantyMapper {

    @Mapping(target = "vehicleId", expression = "java(warranty.getVehicle() != null ? warranty.getVehicle().getId() : null)")
    WarrantyDTO toDTO(Warranty warranty);

    @Mapping(target = "vehicle", ignore = true)
    Warranty toEntity(WarrantyDTO warrantyDTO);
}