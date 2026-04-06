package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends BaseEntity {
    private String name;
    private String role;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "dealership_id")
    private Dealership dealership;
}