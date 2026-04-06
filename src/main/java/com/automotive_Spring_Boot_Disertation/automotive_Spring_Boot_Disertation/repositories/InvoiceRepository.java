package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;


import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
