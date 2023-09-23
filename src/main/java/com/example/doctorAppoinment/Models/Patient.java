package com.example.doctorAppoinment.Models;


import com.example.doctorAppoinment.Enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "patients")
@Data


public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

   private String name;


    private String city;

    @Column(unique = true)
    private String emailId;

    @Enumerated (EnumType.STRING)
    private Symptom symptom;
    private int phoneNo;


    @ManyToOne
    @JoinColumn
    private Doctor doctor;

}
