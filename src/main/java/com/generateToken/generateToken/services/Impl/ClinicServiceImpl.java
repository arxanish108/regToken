package com.generateToken.generateToken.services.Impl;

import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.repositories.ClinicRepository;
import com.generateToken.generateToken.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Clinic addClinic(ClinicDto clinicDto) {
        Clinic clinic = new Clinic();
        clinic.setLocation(clinicDto.getLocation());
        clinic.setIncharge(clinicDto.getIncharge());
        clinic.setFees(clinicDto.getFees());
        clinic.setStartTime(clinicDto.getStartTime());
        clinic.setEndTime(clinicDto.getEndTime());
        Clinic createdClinic = clinicRepository.save(clinic);
//        ClinicDto clinicDto1 = new ClinicDto();
//        clinicDto1.setLocation(createdClinic.getLocation());
//        clinicDto1.setIncharge(createdClinic.getIncharge());
//        clinicDto1.setFees(createdClinic.getFees());
//        clinicDto1.setTime(createdClinic.getTime());
        return createdClinic;
    }


}
