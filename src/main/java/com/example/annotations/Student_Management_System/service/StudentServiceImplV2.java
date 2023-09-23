package com.example.annotations.Student_Management_System.service;

import com.example.annotations.Student_Management_System.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImplV2 implements StudentService{
    @Override
    public List<StudentEntity> getAllStudent() {
        return null;
    }

    @Override
    public StudentEntity getStudentsBasedOnId(int studentId) {
        return null;
    }

    @Override
    public String deleteStudent(int studentId) {
        return null;
    }

    @Override
    public String createStudent(StudentEntity student) {
        return null;
    }

    @Override
    public StudentEntity updateStudent(int studentId, StudentEntity student) {
        return null;
    }
}
