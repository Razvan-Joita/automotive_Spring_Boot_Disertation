package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

}