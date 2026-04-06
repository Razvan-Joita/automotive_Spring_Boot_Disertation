package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer extends BaseEntity {
    private String name;
    private String country;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles = new ArrayList<>();
}