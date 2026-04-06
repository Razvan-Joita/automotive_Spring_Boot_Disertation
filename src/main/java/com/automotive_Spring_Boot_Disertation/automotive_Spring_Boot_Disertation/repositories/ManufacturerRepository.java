package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Page<Manufacturer> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Optional<Manufacturer> findByName(String name);
}