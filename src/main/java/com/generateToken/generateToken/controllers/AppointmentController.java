package com.generateToken.generateToken.controllers;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.entities.Appointment;
import com.generateToken.generateToken.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//public class AppointmentController {
//}
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book1")
    public AppointmentDTOs bookAppointment(@RequestParam Long doctorId,
            @RequestParam Long clinicId,
            @RequestBody AppointmentDTOs appointmentPatient
            ) {
        System.out.println("anish");

        return appointmentService.bookAppointment(doctorId, clinicId, appointmentPatient);
    }

    @GetMapping("/getByNumber")
    public ResponseEntity<Appointment> getPatientByAadhar(@RequestParam String aadharCardNumber){


        Appointment patient = appointmentService.getByAadhar(aadharCardNumber);


        if(patient!=null){
            return ResponseEntity.ok(patient);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

}
