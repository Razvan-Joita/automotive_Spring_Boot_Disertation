package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WarrantyDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long vehicleId;
}