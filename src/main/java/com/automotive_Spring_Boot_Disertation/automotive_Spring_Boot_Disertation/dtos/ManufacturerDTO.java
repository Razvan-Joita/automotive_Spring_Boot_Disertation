package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ManufacturerDTO {
    private Long id;
    private String name;
    private String country;
    private List<Long> vehicleIds;
}