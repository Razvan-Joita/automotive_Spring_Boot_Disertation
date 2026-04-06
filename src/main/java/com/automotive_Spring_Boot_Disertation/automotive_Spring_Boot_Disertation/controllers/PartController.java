package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.controllers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.PartDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.PartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parts")
@RequiredArgsConstructor
@Tag(name = "Parts", description = "Operations for parts management")
public class PartController {

    private final PartService partService;

    @PostMapping
    @Operation(summary = "Create a new part")
    public ResponseEntity<PartDTO> create(@RequestBody PartDTO dto) {
        return ResponseEntity.ok(partService.createPart(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get part by ID")
    public ResponseEntity<PartDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(partService.getPartById(id));
    }

    @GetMapping
    @Operation(summary = "Get all parts with pagination")
    public ResponseEntity<List<PartDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(partService.getAllParts(page, size));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a part")
    public ResponseEntity<PartDTO> update(@PathVariable Long id, @RequestBody PartDTO dto) {
        return ResponseEntity.ok(partService.updatePart(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a part")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        partService.deletePart(id);
        return ResponseEntity.noContent().build();
    }
}
