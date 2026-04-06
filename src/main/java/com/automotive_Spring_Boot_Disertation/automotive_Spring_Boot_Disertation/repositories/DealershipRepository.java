package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;


import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealershipRepository extends JpaRepository<Dealership, Long> {

    List<Dealership> findByLocation(String location);

}