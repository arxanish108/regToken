package com.generateToken.generateToken.services;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.entities.AppointmentPatient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface AppointmentService {
    //String bookAppointment(AppointmentDTOs appointmentDto);
    AppointmentPatient getByAadhar(String aadharCard);

    AppointmentDTOs bookAppointment(Long clinicId,AppointmentDTOs appointmentPatient );
}
