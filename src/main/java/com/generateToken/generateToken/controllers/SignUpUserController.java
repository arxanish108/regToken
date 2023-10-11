package com.generateToken.generateToken.controllers;

import com.generateToken.generateToken.dto.SignupRequest;
import com.generateToken.generateToken.dto.DoctorDTO;
import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.entities.Doctor;
import com.generateToken.generateToken.repositories.ClinicRepository;
import com.generateToken.generateToken.repositories.UserRepository;
import com.generateToken.generateToken.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/home")
public class SignUpUserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository doctorRepository;
    @Autowired
    private ClinicRepository clinicRepository;
    @PostMapping("/register")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {

        DoctorDTO createdUser = authService.createUser(signupRequest);
        if (createdUser == null){
            return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

//    @PostMapping("/{doctorId}/clinics")
//    public ResponseEntity<String> addClinicToDoctor(@PathVariable Long doctorId, @RequestBody Clinic clinic) {
//        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
//        if (optionalDoctor.isPresent()) {
//            Doctor doctor = optionalDoctor.get();
//            clinic.setDoctor(doctor); // Set the relationship
//            clinicRepository.save(clinic);
//            return ResponseEntity.ok("Clinic added to the doctor successfully.");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
