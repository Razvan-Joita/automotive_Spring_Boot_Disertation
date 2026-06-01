package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDTO {

    private Long id;

    private LocalDate date;

    private Long vehicleId;
}