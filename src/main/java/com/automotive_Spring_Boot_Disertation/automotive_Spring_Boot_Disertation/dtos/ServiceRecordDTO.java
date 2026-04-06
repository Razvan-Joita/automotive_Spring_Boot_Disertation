package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ServiceRecordDTO {
    private Long id;
    private String description;
    private LocalDate date;
    private Long vehicleId;
    private Long mechanicId;
    private List<Long> partIds;
}