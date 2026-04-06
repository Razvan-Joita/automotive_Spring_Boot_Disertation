package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.EmployeeDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee entity);
    Employee toEntity(EmployeeDTO dto);
}