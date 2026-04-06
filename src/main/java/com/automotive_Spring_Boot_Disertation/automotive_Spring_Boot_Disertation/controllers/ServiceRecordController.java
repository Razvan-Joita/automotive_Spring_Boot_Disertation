package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.ServiceRecordDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.ServiceRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/service-records")
@RequiredArgsConstructor
@Tag(name = "Service Records", description = "CRUD operations for service records")
public class ServiceRecordController {

    private final ServiceRecordService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a service record")
    public ServiceRecordDTO create(@RequestBody ServiceRecordDTO dto) {
        return service.createServiceRecord(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a service record by ID")
    public ServiceRecordDTO get(@PathVariable Long id) {
        return service.getServiceRecord(id);
    }

    @GetMapping
    @Operation(summary = "Get all service records with pagination and optional search")
    public Page<ServiceRecordDTO> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getAllServiceRecords(pageable, search);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a service record")
    public ServiceRecordDTO update(@PathVariable Long id, @RequestBody ServiceRecordDTO dto) {
        return service.updateServiceRecord(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a service record")
    public void delete(@PathVariable Long id) {
        service.deleteServiceRecord(id);
    }
}