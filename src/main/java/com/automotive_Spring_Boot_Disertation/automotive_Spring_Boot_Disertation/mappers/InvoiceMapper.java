package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.InvoiceDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(source = "serviceRecord.id", target = "serviceRecordId")
    InvoiceDTO toDTO(Invoice entity);

    @Mapping(target = "serviceRecord", ignore = true)
    Invoice toEntity(InvoiceDTO dto);
}