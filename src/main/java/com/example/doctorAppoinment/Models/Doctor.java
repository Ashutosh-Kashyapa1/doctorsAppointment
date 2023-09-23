package com.example.doctorAppoinment.Models;



import com.example.doctorAppoinment.Enums.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;

    private String name;

    @Enumerated (EnumType.STRING)
    private City city;

    @Column(unique = true)
    private String emailId;

    private int phoneNo;
    private HashMap<String, List<String>> Speciality = new HashMap<>();



    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Patient> patientList = new ArrayList<>();


}
