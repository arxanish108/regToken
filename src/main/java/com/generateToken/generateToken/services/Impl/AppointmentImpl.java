package com.generateToken.generateToken.services.Impl;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.entities.AppointmentPatient;
import com.generateToken.generateToken.repositories.AppointmentRepository;
import com.generateToken.generateToken.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public String bookAppointment(AppointmentDTOs appointmentDto) {
        AppointmentPatient patientAppointment = new AppointmentPatient();


        patientAppointment.setName(appointmentDto.getName());
        patientAppointment.setContactNumber(appointmentDto.getContactNumber());
        patientAppointment.setAadharNumber(appointmentDto.getAadharNumber());
        patientAppointment.setAge(appointmentDto.getAge());
        patientAppointment.setGender(appointmentDto.getGender());
        patientAppointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        patientAppointment.setAppointmentTime(appointmentDto.getAppointmentTime());
        patientAppointment.setClinicLocation(appointmentDto.getClinicLocation());

        patientAppointment = appointmentRepository.save(patientAppointment);

        return "Slot Bookend Successfully";
    }
}
