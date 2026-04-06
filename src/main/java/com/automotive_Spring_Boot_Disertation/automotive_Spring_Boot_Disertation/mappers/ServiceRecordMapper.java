package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.ServiceRecordDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Part;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.ServiceRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ServiceRecordMapper {

    @Mapping(target = "vehicleId", expression = "java(serviceRecord.getVehicle() != null ? serviceRecord.getVehicle().getId() : null)")
    @Mapping(target = "mechanicId", expression = "java(serviceRecord.getMechanic() != null ? serviceRecord.getMechanic().getId() : null)")
    @Mapping(target = "partIds", source = "parts", qualifiedByName = "partsToIds")
    ServiceRecordDTO toDTO(ServiceRecord serviceRecord);

    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "mechanic", ignore = true)
    @Mapping(target = "parts", ignore = true)
    ServiceRecord toEntity(ServiceRecordDTO serviceRecordDTO);

    @Named("partsToIds")
    default List<Long> partsToIds(List<Part> parts) {
        if (parts == null) {
            return Collections.emptyList();
        }
        return parts.stream()
                .map(Part::getId)
                .collect(Collectors.toList());
    }
}