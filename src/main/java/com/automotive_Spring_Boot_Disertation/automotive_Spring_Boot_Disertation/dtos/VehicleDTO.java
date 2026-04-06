package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.Data;

@Data
public class VehicleDTO {
    private Long id;
    private String vin;
    private String licensePlate;
    private String make;
    private String model;
    private Integer year;
    private String fuelType;
    private String status;
    private Long manufacturerId;
}