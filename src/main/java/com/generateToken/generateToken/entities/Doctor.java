package com.generateToken.generateToken.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
    private String degree;
    private int experience;
    private String research_journal;
    private String citations;
    private String contact;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Clinic> clinics = new ArrayList<>();

}
