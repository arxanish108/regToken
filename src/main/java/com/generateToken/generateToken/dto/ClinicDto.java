package com.generateToken.generateToken.dto;

import com.generateToken.generateToken.entities.Doctor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicDto {

    private String location;
    private String incharge;
    private int fees;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;
}
