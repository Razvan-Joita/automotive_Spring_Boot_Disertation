package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;


import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {

    List<Part> findByNameContainingIgnoreCase(String name);

}
