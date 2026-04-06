package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Appointment extends BaseEntity {

    private LocalDate date;

    @ManyToOne
    private Vehicle vehicle;
}