package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos;

import lombok.Data;

@Data
public class InvoiceDTO {

    private Long id;

    private Double amount;

    private Long serviceRecordId;
}