package com.generateToken.generateToken.services.Impl;

import com.generateToken.generateToken.dto.SignupRequest;
import com.generateToken.generateToken.dto.DoctorDTO;
import com.generateToken.generateToken.repositories.UserRepository;
import com.generateToken.generateToken.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import com.generateToken.generateToken.entities.Doctor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public DoctorDTO createUser(SignupRequest signupRequest) {
        Doctor doctor = new Doctor();
        doctor.setName(signupRequest.getName());
        doctor.setSpecialization(signupRequest.getSpecialization());
        doctor.setDegree(signupRequest.getDegree());
        doctor.setExperience(signupRequest.getExperience());
        doctor.setResearch_journal(signupRequest.getResearch_journal());
        doctor.setCitations(signupRequest.getCitations());
        doctor.setContact(signupRequest.getContact());
        doctor.setEmail(signupRequest.getEmail());
        //user.setPassword(signupRequest.getPassword());
        doctor.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        Doctor createdDoctor = userRepository.save(doctor);
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setName(createdDoctor.getName());
        doctorDTO.setSpecialization(createdDoctor.getSpecialization());
        doctorDTO.setDegree(createdDoctor.getDegree());
        doctorDTO.setExperience(createdDoctor.getExperience());
        doctorDTO.setResearch_journal(createdDoctor.getResearch_journal());
        doctorDTO.setCitations(createdDoctor.getCitations());
        doctorDTO.setContact(createdDoctor.getContact());
        doctorDTO.setEmail(createdDoctor.getEmail());
        doctorDTO.setPassword(createdDoctor.getPassword());
        return doctorDTO;
//        user.setName(signupRequest.getName());
//        user.setEmail(signupRequest.getEmail());
//        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
//        User createdUser = userRepository.save(user);
//        UserDTO userDTO = new UserDTO();
//        userDTO.setEmail(createdUser.getEmail());
//        userDTO.setName(createdUser.getName());
//        userDTO.setPassword(createdUser.getPassword());
//        return userDTO;
    }


}
