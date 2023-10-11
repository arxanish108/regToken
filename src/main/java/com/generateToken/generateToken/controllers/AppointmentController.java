package com.generateToken.generateToken.controllers;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.entities.AppointmentPatient;
import com.generateToken.generateToken.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//public class AppointmentController {
//}
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

//    @PostMapping("/book")
//    public String bookAppointment(@RequestBody AppointmentDTOs appointmentDto){
//        System.out.println(appointmentDto.getAadharNumber());
//        try {
//            String result = appointmentService.bookAppointment(appointmentDto);
//            return result;
//        } catch (Exception e){
//            return e.getMessage();
//        }
//    }

    @PostMapping("/book1")
    public AppointmentDTOs bookAppointment(
            @RequestParam Long clinicId,
            @RequestBody AppointmentDTOs appointmentPatient
            ) {
        System.out.println("anish");
        return appointmentService.bookAppointment( clinicId, appointmentPatient);
    }

    @GetMapping("/getByNumber")
    public ResponseEntity<AppointmentPatient> getPatientByAadhar(@RequestParam String aadharCardNumber){

        AppointmentPatient patient = appointmentService.getByAadhar(aadharCardNumber);

        if(patient!=null){
            return ResponseEntity.ok(patient);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

}
