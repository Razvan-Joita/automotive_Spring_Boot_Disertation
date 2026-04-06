package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}