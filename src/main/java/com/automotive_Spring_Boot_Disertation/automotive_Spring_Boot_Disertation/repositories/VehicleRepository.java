package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // Keep only valid methods based on Vehicle entity fields
    Optional<Vehicle> findByVin(String vin);

    Optional<Vehicle> findByLicensePlate(String licensePlate);

    List<Vehicle> findByStatus(String status);

    List<Vehicle> findByMake(String make);

    List<Vehicle> findByModel(String model);

    Page<Vehicle> findByMakeContainingIgnoreCase(String make, Pageable pageable);

    // Remove this method if it doesn't exist in Vehicle entity
    // List<Vehicle> findByOwnerId(Long ownerId); // COMMENT OUT OR REMOVE THIS LINE

    // If you need to find by manufacturer, use:
    List<Vehicle> findByManufacturerId(Long manufacturerId);
}