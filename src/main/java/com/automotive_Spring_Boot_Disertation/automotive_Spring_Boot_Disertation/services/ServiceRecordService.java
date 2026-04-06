package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.ServiceRecordDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceRecordService {
    ServiceRecordDTO createServiceRecord(ServiceRecordDTO dto);

    ServiceRecordDTO getServiceRecord(Long id);

    Page<ServiceRecordDTO> getAllServiceRecords(Pageable pageable, String search);

    ServiceRecordDTO updateServiceRecord(Long id, ServiceRecordDTO dto);

    void deleteServiceRecord(Long id);
}