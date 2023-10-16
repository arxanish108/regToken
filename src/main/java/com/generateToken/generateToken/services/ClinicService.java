package com.generateToken.generateToken.services;

import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.entities.Clinic;

import java.util.Optional;

public interface ClinicService {
    Clinic addClinic(ClinicDto clinicDto);

    Optional<Clinic> getClinicById(Long id);

    //Optional<ClinicDto> getClinicById(Long clinicId);
}
