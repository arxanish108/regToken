package com.generateToken.generateToken.services;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.entities.Clinic;

import java.util.List;
import java.util.Optional;

public interface ClinicService {
    ClinicDto addClinic(Long userId,ClinicDto clinicDto);

    Optional<Clinic> getClinicById(Long id);

    List<AppointmentDTOs> getAppointments(Long clinicId);
}
