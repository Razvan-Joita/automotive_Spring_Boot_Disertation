package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String role;
    private String email;
    private String phone;
    private Long dealershipId;
}