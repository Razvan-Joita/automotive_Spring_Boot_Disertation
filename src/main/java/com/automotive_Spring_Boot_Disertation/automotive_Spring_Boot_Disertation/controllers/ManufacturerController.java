package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.ManufacturerDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.ManufacturerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manufacturers")
@Tag(name = "Manufacturers", description = "CRUD operations for manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @PostMapping
    @Operation(summary = "Create a manufacturer")
    public ManufacturerDTO create(@RequestBody ManufacturerDTO dto) {
        return manufacturerService.createManufacturer(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a manufacturer by ID")
    public ManufacturerDTO get(@PathVariable Long id) {
        return manufacturerService.getManufacturer(id);
    }

    @GetMapping
    @Operation(summary = "Get all manufacturers with pagination and optional search")
    public Page<ManufacturerDTO> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search) {
        Pageable pageable = PageRequest.of(page, size);
        return manufacturerService.getAllManufacturers(pageable, search); // Fixed: Pass both parameters
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a manufacturer by ID")
    public ManufacturerDTO update(@PathVariable Long id, @RequestBody ManufacturerDTO dto) {
        return manufacturerService.updateManufacturer(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a manufacturer by ID")
    public void delete(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
    }
}