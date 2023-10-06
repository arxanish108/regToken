package com.generateToken.generateToken.services;

import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.entities.Clinic;

public interface ClinicService {
    Clinic addClinic(ClinicDto clinicDto);
}
