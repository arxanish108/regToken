package com.generateToken.generateToken.services.Impl;

import com.generateToken.generateToken.Gender.Gender;
import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.entities.AppointmentPatient;
import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.entities.Doctor;
import com.generateToken.generateToken.repositories.AppointmentRepository;
import com.generateToken.generateToken.repositories.ClinicRepository;
import com.generateToken.generateToken.repositories.UserRepository;
import com.generateToken.generateToken.services.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClinicRepository clinicRepository;
//    @Override
//    public String bookAppointment(AppointmentDTOs appointmentDto) {
//        AppointmentPatient patientAppointment = new AppointmentPatient();
//
//        patientAppointment.setName(appointmentDto.getName());
//        patientAppointment.setContactNumber(appointmentDto.getContactNumber());
//        patientAppointment.setAadharNumber(appointmentDto.getAadharNumber());
//        patientAppointment.setAge(appointmentDto.getAge());
//        patientAppointment.setGender(appointmentDto.getGender());
//        patientAppointment.setAppointmentDate(appointmentDto.getAppointmentDate());
//        patientAppointment.setAppointmentTime(appointmentDto.getAppointmentTime());
//        patientAppointment.setClinicLocation(appointmentDto.getClinicLocation());
//
//        patientAppointment = appointmentRepository.save(patientAppointment);
//
//        return "Slot Bookend Successfully";
//    }

    @Override
    public AppointmentPatient getByAadhar(String aadharCard) {
      // return appointmentRepository.findByAadharCard(aadharCard);
        return null;
    }

    @Override
    public AppointmentDTOs bookAppointment(Long clinicId, AppointmentDTOs appointmentDto) {

        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new EntityNotFoundException("Clinic not found"));

        Doctor doctor = userRepository.findById(clinicId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));


        AppointmentPatient patientAppointment = new AppointmentPatient();

        patientAppointment.setName(appointmentDto.getName());
        patientAppointment.setContactNumber(appointmentDto.getContactNumber());
        patientAppointment.setAadharNumber(appointmentDto.getAadharNumber());
        patientAppointment.setAge(appointmentDto.getAge());
        patientAppointment.setGender(appointmentDto.getGender());
        patientAppointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        patientAppointment.setAppointmentTime(appointmentDto.getAppointmentTime());
        patientAppointment.setClinicLocation(appointmentDto.getClinicLocation());
        patientAppointment.setClinic(clinic);
        patientAppointment.setDoctor(doctor);


        patientAppointment = appointmentRepository.save(patientAppointment);


        AppointmentDTOs appointmentDto1 =  new AppointmentDTOs();
        appointmentDto1.setName(patientAppointment.getName());
        appointmentDto1.setContactNumber(patientAppointment.getContactNumber());
        appointmentDto1.setAadharNumber(patientAppointment.getAadharNumber());
        appointmentDto1.setAge(patientAppointment.getAge());
        appointmentDto1.setGender(patientAppointment.getGender());
        appointmentDto1.setAppointmentDate(patientAppointment.getAppointmentDate());
        appointmentDto1.setAppointmentTime(patientAppointment.getAppointmentTime());
        appointmentDto1.setClinicLocation(patientAppointment.getClinicLocation());


        clinic.addAppointmentPatient(patientAppointment);
        doctor.addAppointmentPatient1(patientAppointment);

        patientAppointment = appointmentRepository.save(patientAppointment);
        clinic = clinicRepository.save(clinic);
        doctor = userRepository.save(doctor);

        return appointmentDto1;
    }

}
