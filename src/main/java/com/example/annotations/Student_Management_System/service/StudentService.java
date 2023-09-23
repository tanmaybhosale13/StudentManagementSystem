package com.example.annotations.Student_Management_System.service;

import com.example.annotations.Student_Management_System.entity.StudentEntity;

import java.util.List;


public interface StudentService {

    List<StudentEntity> getAllStudent();

    StudentEntity getStudentsBasedOnId(int studentId);


     public  String  deleteStudent(int studentId);


     public  String  createStudent(StudentEntity student);


     StudentEntity  updateStudent(int studentId,StudentEntity student);


}

