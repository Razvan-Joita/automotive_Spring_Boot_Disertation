package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.UserDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "CRUD operations for Users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @Operation(summary = "Create a User")
    public UserDTO create(@RequestBody UserDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a User by ID")
    public UserDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    @Operation(summary = "Get all Users with pagination and optional search")
    public Page<UserDTO> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getAll(pageable, search); // Fixed: Pass both parameters
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a User")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a User")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}