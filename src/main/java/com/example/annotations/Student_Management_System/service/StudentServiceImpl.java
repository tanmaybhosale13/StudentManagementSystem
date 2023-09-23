package com.example.annotations.Student_Management_System.service;


import com.example.annotations.Student_Management_System.entity.StudentEntity;
import com.example.annotations.Student_Management_System.exception.StudentNotFoundException;
import com.example.annotations.Student_Management_System.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStudentsBasedOnId(int studentId) {
        Optional<StudentEntity> student = studentRepository.findById(studentId);

        if (student.isPresent()) {

            return student.get();
        } else {

            Throwable cause = new Exception("Student with ID not found: " + studentId);
            throw new StudentNotFoundException("Student not found with ID: " + studentId, cause);
        }


    }

    @Override
    public String deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
        return "student deleted";
    }

    @Override
    public String createStudent(StudentEntity student) {
        studentRepository.save(student);
        return "student created";
    }

    @Override
    public StudentEntity updateStudent(int studentId, StudentEntity student) {
        Optional<StudentEntity> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            StudentEntity studentToUpdate = existingStudent.get();

            studentToUpdate.setStudentName(student.getStudentName());
            studentToUpdate.setStudentCollege(student.getStudentCollege());
            studentToUpdate.setStudentAddress(student.getStudentAddress());
            studentRepository.save(studentToUpdate);
            return studentToUpdate;
        } else {
            throw new StudentNotFoundException("Student not found with id ", studentId);
        }


    }


}
