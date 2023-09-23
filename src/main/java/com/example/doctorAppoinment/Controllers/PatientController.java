package com.example.doctorAppoinment.Controllers;


import com.example.doctorAppoinment.Models.Patient;
import com.example.doctorAppoinment.Services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")

public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public Patient addPatient( @Valid @RequestBody Patient patient){

        return patientService.addPatient(patient);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") int id)
    {
        return patientService.deleteById(id);
    }

    @GetMapping("/get-doctor-by-patient-id/{id}")
    public List<String> getDoctorByPatientId(@PathVariable int id){
        List<String> doctorList= patientService.getDoctorByPatientId(id);
           return doctorList;
    }

}
