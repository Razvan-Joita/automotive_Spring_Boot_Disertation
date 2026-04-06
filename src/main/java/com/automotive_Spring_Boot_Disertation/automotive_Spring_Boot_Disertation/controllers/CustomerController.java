package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.CustomerDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "CRUD operations for customers")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary = "Create a customer")
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a customer")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer by ID")
    public ResponseEntity<CustomerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all customers")
    public ResponseEntity<Page<CustomerDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}