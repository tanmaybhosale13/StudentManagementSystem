package com.example.annotations.Student_Management_System.repository;


import com.example.annotations.Student_Management_System.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {


}
