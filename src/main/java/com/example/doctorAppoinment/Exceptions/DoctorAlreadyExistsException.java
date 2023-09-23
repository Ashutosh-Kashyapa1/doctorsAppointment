package com.example.doctorAppoinment.Exceptions;

public class DoctorAlreadyExistsException extends Exception{
    public DoctorAlreadyExistsException(String message){
        super(message);
    }
}
