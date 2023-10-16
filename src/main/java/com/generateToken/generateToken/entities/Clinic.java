package com.generateToken.generateToken.entities;

import com.generateToken.generateToken.dto.ClinicDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// "doctorId": 15,
//         "clinicId": 6,
//         "name": "Md Anish",
//         "contactNumber": "65432345",
//         "aadharNumber": "659789244905",
//         "age": 30,
//         "gender": "MALE",
//         "appointmentDate": "2023-12-11",
//         "appointmentTime": "08:00",
//         "clinicLocation": "MZPR"
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
    @JoinColumn(name = "doctorId")
    private Doctor doctor;



    @OneToMany( cascade = CascadeType.ALL)
    private List<AppointmentPatient> clinics = new ArrayList<>();

    public void addAppointmentPatient(AppointmentPatient appointmentPatient){
        this.clinics.add(appointmentPatient);
    }

    //private HashMap<Clinic, List<AppointmentPatient>> map = new HashMap<>();


}
