package com.example.doctorAppoinment.Services;

import com.example.doctorAppoinment.Models.Doctor;
import com.example.doctorAppoinment.Models.Patient;
import com.example.doctorAppoinment.Repository.DoctorRepository;
import com.example.doctorAppoinment.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.doctorAppoinment.Enums.City.*;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public Patient addPatient(Patient patient){
        patient = patientRepository.save(patient);
        return patient;
    }

    public String deleteById( int patientId){
        patientRepository.deleteById(patientId);
        return "patient is deleted from database";
    }

    public List<String> getDoctorByPatientId(int patientId){
        Patient patient = patientRepository.findById(patientId).get();
        List<String> requiredDoctor = new ArrayList<>();
        List<Doctor> doctorList = doctorRepository.findAll();
        String patientCity = patient.getCity();
        List<String> doctorAvailabiltyInCity = new ArrayList<>();
        doctorAvailabiltyInCity.add( DELHI.toString());
        doctorAvailabiltyInCity.add(NOIDA.toString());
        doctorAvailabiltyInCity.add(FARIDABAD.toString());

        for(Doctor doctor : doctorList ){
            if(doctor.getSpeciality().containsValue(patient.getSymptom()) && doctorAvailabiltyInCity.contains(patientCity)){
              requiredDoctor.add(doctor.getName());
            }
         }

          return requiredDoctor;
    }

}
