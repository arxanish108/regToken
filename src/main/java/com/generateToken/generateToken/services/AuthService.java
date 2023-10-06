package com.generateToken.generateToken.services;

import com.generateToken.generateToken.dto.SignupRequest;
import com.generateToken.generateToken.dto.DoctorDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    DoctorDTO createUser(SignupRequest signupRequest);

}
