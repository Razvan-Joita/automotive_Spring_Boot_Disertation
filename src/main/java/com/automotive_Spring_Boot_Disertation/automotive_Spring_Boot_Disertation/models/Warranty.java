package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warranty extends BaseEntity {
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}