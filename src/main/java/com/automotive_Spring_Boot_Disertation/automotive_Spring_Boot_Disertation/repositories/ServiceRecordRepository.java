package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.ServiceRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {

    List<ServiceRecord> findByVehicleId(Long vehicleId);

    List<ServiceRecord> findByMechanicId(Long mechanicId);

    // Add search method
    Page<ServiceRecord> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);

    // Optional: Add more search methods
    Page<ServiceRecord> findByVehicleVinContainingIgnoreCase(String vin, Pageable pageable);
}