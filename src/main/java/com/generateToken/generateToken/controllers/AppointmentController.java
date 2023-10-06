package com.generateToken.generateToken.controllers;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//public class AppointmentController {
//}
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public String bookAppointment(@RequestBody AppointmentDTOs appointmentDto){
        System.out.println(appointmentDto.getAadharNumber());
        try {
            String result = appointmentService.bookAppointment(appointmentDto);
            return result;
        } catch (Exception e){
            return e.getMessage();
        }
    }

}
