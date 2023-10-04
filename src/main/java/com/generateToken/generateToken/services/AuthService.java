package com.generateToken.generateToken.services;

import com.generateToken.generateToken.dto.SignupRequest;
import com.generateToken.generateToken.dto.UserDTO;
import com.generateToken.generateToken.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    UserDTO createUser(SignupRequest signupRequest);
}
