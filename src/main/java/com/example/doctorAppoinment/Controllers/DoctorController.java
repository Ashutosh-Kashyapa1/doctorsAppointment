package com.example.doctorAppoinment.Controllers;

import com.example.doctorAppoinment.Models.Doctor;
import com.example.doctorAppoinment.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){

        try {
            String response = doctorService.addDoctor(doctor);
            return response;
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") int id)
    {
        return doctorService.deleteById(id);
    }


}
