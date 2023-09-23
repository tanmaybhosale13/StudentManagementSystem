package com.example.annotations.Student_Management_System.exception;

public class StudentNotFoundException extends RuntimeException{


    public StudentNotFoundException(String message,int studentId) {
        super(message+studentId);
    }

    public StudentNotFoundException(String message,int studentId, Throwable cause) {
        super(message+studentId, cause);
    }


    public StudentNotFoundException(String message, Throwable cause) {
        super(message+cause);
    }
}
