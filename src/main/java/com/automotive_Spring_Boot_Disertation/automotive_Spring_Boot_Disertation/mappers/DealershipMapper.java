package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.DealershipDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Dealership;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DealershipMapper {
    DealershipDTO toDTO(Dealership entity);
    Dealership toEntity(DealershipDTO dto);
}