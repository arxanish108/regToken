package com.generateToken.generateToken.repositories;

import com.generateToken.generateToken.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    //AppointmentPatient findByAadharCard(String aadharCard);

}
