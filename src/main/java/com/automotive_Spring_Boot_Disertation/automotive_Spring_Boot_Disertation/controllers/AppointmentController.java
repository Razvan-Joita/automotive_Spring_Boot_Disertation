package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.AppointmentDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
@Tag(name = "Appointments", description = "CRUD operations for appointments")
public class AppointmentController {

    private final AppointmentService service;

    @PostMapping
    @Operation(summary = "Create appointment")
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get appointment by ID")
    public ResponseEntity<AppointmentDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all appointments")
    public ResponseEntity<Page<AppointmentDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update appointment")
    public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @RequestBody AppointmentDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete appointment")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}