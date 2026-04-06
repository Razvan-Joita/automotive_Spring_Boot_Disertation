package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories;


import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByVehicleId(Long vehicleId);

    List<Appointment> findByDate(LocalDate date);

}
