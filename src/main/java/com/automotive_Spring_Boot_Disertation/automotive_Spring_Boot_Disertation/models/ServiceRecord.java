package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRecord extends BaseEntity {
    private String description;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Employee mechanic;

    @ManyToMany
    @JoinTable(
            name = "service_record_parts",
            joinColumns = @JoinColumn(name = "service_record_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id")
    )
    private List<Part> parts = new ArrayList<>();
}