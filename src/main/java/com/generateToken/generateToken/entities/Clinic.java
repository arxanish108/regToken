package com.generateToken.generateToken.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "clinic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String incharge;
    private int fees;

    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;

}
