package com.generateToken.generateToken.controllers;

import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @PostMapping("/addClinic")
    public ResponseEntity<String> createClinic(@RequestBody ClinicDto clinicDto){
        System.out.println("hello");
        Clinic clinic = clinicService.addClinic(clinicDto);
        return ResponseEntity.ok("Clinic added to doctor successfully");
    }
}