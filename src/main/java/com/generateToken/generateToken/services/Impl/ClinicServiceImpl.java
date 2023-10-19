package com.generateToken.generateToken.services.Impl;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.dto.DoctorDTO;
import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.entities.Doctor;
import com.generateToken.generateToken.repositories.ClinicRepository;
import com.generateToken.generateToken.repositories.UserRepository;
import com.generateToken.generateToken.services.ClinicService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private UserRepository doctorRepository;

    public List<AppointmentDTOs> getAppointments (Long clinicId){

        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new EntityNotFoundException("Clinic not found"));
        System.out.println(clinic.getId());

        return  clinic.getAppointmentDto();
    }

    public ClinicDto addClinic(Long doctorId, ClinicDto clinicDto) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));

        DoctorDTO doctorDTO = new DoctorDTO();

        Clinic clinic = new Clinic();
        clinic.setLocation(clinicDto.getLocation());
        clinic.setIncharge(clinicDto.getIncharge());
        clinic.setFees(clinicDto.getFees());
        clinic.setStartTime(clinicDto.getStartTime());
        clinic.setEndTime(clinicDto.getEndTime());
        clinic.setDoctor(doctor);
        clinic = clinicRepository.save(clinic);

        ClinicDto clinicDto1 = new ClinicDto();
        clinicDto1.setLocation(clinic.getLocation());
        clinicDto1.setIncharge(clinic.getIncharge());
        clinicDto1.setFees(clinic.getFees());
        clinicDto1.setStartTime(clinic.getStartTime());
        clinicDto1.setEndTime(clinic.getEndTime());

        doctor.addClinic(clinic);

        //  clinic = clinicRepository.save(clinic);
        doctor = doctorRepository.save(doctor);

        return clinicDto1;
    }

    public Optional<Clinic> getClinicById(Long clinicId) {
        return clinicRepository.findById(clinicId);
    }



}
