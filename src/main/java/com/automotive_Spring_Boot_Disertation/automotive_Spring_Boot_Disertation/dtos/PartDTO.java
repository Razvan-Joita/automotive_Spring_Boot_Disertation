package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PartDTO {
    private Long id;
    private String partNumber;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}