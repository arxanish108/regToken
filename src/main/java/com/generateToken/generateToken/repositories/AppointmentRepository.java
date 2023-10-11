package com.generateToken.generateToken.repositories;

import com.generateToken.generateToken.entities.AppointmentPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentPatient,Integer> {
    //AppointmentPatient findByAadharCard(String aadharCard);

}
