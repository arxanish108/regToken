package com.generateToken.generateToken.repositories;

import com.generateToken.generateToken.entities.AppointmentPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentRepository extends JpaRepository<AppointmentPatient,Integer> {
}
