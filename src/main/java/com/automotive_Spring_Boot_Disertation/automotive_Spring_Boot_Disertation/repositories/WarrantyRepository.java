package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Warranty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    // Add search by vehicle VIN or other criteria
    Page<Warranty> findByVehicleVinContainingIgnoreCase(String vin, Pageable pageable);
}