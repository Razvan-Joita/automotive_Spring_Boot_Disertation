package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BaseEntity {
    private String vin;
    private String licensePlate;
    private String make;
    private String model;
    private Integer year;
    private String fuelType;
    private String status;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}