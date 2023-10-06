package com.generateToken.generateToken.repositories;

import com.generateToken.generateToken.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Doctor,Long> {
    Doctor findFirstByEmail(String email);

}
