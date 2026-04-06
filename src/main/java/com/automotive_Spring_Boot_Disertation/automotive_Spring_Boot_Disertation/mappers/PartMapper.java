package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.PartDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Part;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartMapper {
    PartDTO toDTO(Part entity);
    Part toEntity(PartDTO dto);
}