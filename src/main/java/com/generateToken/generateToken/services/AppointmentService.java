package com.generateToken.generateToken.services;

import com.generateToken.generateToken.dto.AppointmentDTOs;

public interface AppointmentService {
    String bookAppointment(AppointmentDTOs appointmentDto);

}
