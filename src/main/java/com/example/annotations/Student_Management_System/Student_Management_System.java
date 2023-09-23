package com.example.annotations.Student_Management_System;

import com.example.annotations.Student_Management_System.entity.StudentEntity;
import com.example.annotations.Student_Management_System.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Student_Management_System implements CommandLineRunner {


    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Student_Management_System.class, args);

    }

    static Faker faker = new Faker();
    public void addRandomStudents(int numberOfStudents) {

        for (int i = 0; i < numberOfStudents; i++) {
            StudentEntity student = new StudentEntity();
            student.setStudentName(faker.name().fullName());
            student.setStudentAddress(faker.address().fullAddress());
            student.setStudentCollege(faker.university().name());

            studentRepository.save(student);
        }
    }

    @Override
    public void run(String... args) throws Exception {

        addRandomStudents(100);

    }
}
