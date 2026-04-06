package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.UserDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.UserMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.User;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.UserRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO create(UserDTO dto) {
        User user = mapper.toEntity(dto);
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return mapper.toDTO(repository.save(user));
    }

    @Override
    public UserDTO getById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public Page<UserDTO> getAll(Pageable pageable, String search) {
        Page<User> page;
        if (search != null && !search.isEmpty()) {
            page = repository.findByUsernameContainingIgnoreCase(search, pageable);
        } else {
            page = repository.findAll(pageable);
        }
        return page.map(mapper::toDTO);
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        user.setUsername(dto.getUsername());
        // Only update password if provided and not empty
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        user.setRole(dto.getRole());

        return mapper.toDTO(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        repository.deleteById(id);
    }
}