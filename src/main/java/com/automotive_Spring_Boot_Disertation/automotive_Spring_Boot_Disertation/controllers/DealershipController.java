package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.DealershipDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.DealershipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dealerships")
@RequiredArgsConstructor
@Tag(name = "Dealerships", description = "Dealership management")
public class DealershipController {

    private final DealershipService service;

    @PostMapping
    @Operation(summary = "Create new dealership")
    public ResponseEntity<DealershipDTO> create(@RequestBody DealershipDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get dealership by ID")
    public ResponseEntity<DealershipDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all dealerships with pagination")
    public ResponseEntity<List<DealershipDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update dealership")
    public ResponseEntity<DealershipDTO> update(@PathVariable Long id, @RequestBody DealershipDTO dto){
        return ResponseEntity.ok(service.update(id,dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete dealership")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}