package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.InvoiceDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invoices")
@RequiredArgsConstructor
@Tag(name = "Invoices", description = "CRUD operations for invoices")
public class InvoiceController {

    private final InvoiceService service;

    @PostMapping
    @Operation(summary = "Create invoice")
    public ResponseEntity<InvoiceDTO> create(@RequestBody InvoiceDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get invoice by ID")
    public ResponseEntity<InvoiceDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all invoices")
    public ResponseEntity<Page<InvoiceDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update invoice")
    public ResponseEntity<InvoiceDTO> update(@PathVariable Long id, @RequestBody InvoiceDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete invoice")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}