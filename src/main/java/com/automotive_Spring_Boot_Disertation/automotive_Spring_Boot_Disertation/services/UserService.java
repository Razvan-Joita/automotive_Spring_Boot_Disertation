package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO getById(Long id);
    Page<UserDTO> getAll(Pageable pageable, String search); // Fixed: Returns Page, accepts Pageable and search
    UserDTO update(Long id, UserDTO dto);
    void delete(Long id);
}