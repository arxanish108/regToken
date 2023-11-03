package com.generateToken.generateToken.services;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.entities.Appointment;
import com.generateToken.generateToken.entities.Clinic;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClinicService {
    ClinicDto addClinic(Long userId,ClinicDto clinicDto);

    Optional<Clinic> getClinicById(Long id);

    List<AppointmentDTOs> getAppointments(Long clinicId);


    List<AppointmentDTOs> getAppointmentBetweenDate(Long clinicId, LocalDate startDate, LocalDate endDate);

    Double findAmountForClinicInDateRange(Long clinicId, Date startDate, Date endDate);
}
