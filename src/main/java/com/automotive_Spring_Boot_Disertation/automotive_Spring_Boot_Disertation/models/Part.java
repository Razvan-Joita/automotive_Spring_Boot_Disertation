package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Part extends BaseEntity {
    private String name;
    private String partNumber;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}