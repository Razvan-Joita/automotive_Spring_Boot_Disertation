package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.UserDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User entity);
    User toEntity(UserDTO dto);
}