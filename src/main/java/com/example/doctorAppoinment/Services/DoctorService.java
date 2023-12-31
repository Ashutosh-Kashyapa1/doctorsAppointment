package com.example.doctorAppoinment.Services;

import com.example.doctorAppoinment.Exceptions.DoctorAlreadyExistsException;
import com.example.doctorAppoinment.Exceptions.EmailIdEmptyException;
import com.example.doctorAppoinment.Models.Doctor;
import com.example.doctorAppoinment.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor)throws EmailIdEmptyException, DoctorAlreadyExistsException {

        //Validations part is over :
        if(doctor.getEmailId()==null){
            throw new EmailIdEmptyException("Email id is mandatory");
        }

        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null){
            throw new DoctorAlreadyExistsException("Doctor with this emailId already exits.");
        }

        doctorRepository.save(doctor);

        return "Doctor has been added to the database";
    }

    public String deleteById( int docId){
       doctorRepository.deleteById(docId);
       return "Doctor is deleted from database";
    }

}
