package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.WarrantyDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.WarrantyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/warranties")
@Tag(name = "Warranties", description = "CRUD operations for Warranties")
public class WarrantyController {

    @Autowired
    private WarrantyService service;

    @PostMapping
    @Operation(summary = "Create a Warranty")
    public WarrantyDTO create(@RequestBody WarrantyDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Warranty by ID")
    public WarrantyDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    @Operation(summary = "Get all Warranties with pagination and optional search")
    public Page<WarrantyDTO> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getAll(pageable, search);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Warranty")
    public WarrantyDTO update(@PathVariable Long id, @RequestBody WarrantyDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Warranty")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}