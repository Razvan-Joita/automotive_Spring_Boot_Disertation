package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dealership extends BaseEntity {

    private String name;
    private String location;
}