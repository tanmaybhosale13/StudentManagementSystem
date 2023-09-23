package com.example.annotations.Student_Management_System.controller;

import com.example.annotations.Student_Management_System.bean.LazyLoadingBean;
import com.example.annotations.Student_Management_System.bean.TestBean;
import com.example.annotations.Student_Management_System.entity.StudentEntity;
import com.example.annotations.Student_Management_System.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@PropertySource("custom.properties")
public class StudentController {


    @Autowired
    // @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @Autowired
    private TestBean testBean;


    @Value("${mail.from}")
    private String from;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;


    @Value("${message}")
    private String message;


    @Autowired
    private LazyLoadingBean lazyLoadingBean;

    @GetMapping("/students")
    public ResponseEntity<List<StudentEntity>> getAllStudentDetails(HttpServletRequest httpServletRequest) throws UnknownHostException {

        testBean.m1();
        System.out.println("Application.Properties key and value are load using @Value annotation " + from + " " + host + " " + port);
        System.out.println("Custom.properties key and value are load using @PropertySource annotation :" + message);
        List<StudentEntity> listOfStudents = studentService.getAllStudent();

        String clientIpAddress = httpServletRequest.getRemoteAddr();

        String userAgent = httpServletRequest.getHeader("User-Agent");
        System.out.println(clientIpAddress);
        System.out.println(userAgent);




//        InetAddress.getLoopbackAddress().getHostAddress();
//        InetAddress.getLoopbackAddress().getHostName();
//
//        InetAddress.getLocalHost().getHostAddress();
//        InetAddress.getLocalHost().getHostName();

        if (listOfStudents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(listOfStudents, HttpStatus.OK);
        }

    }


    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentEntity> getStudentBasedOnId(@PathVariable int studentId) {

        StudentEntity studentDetailsBasedOnId = studentService.getStudentsBasedOnId(studentId);


        if (studentDetailsBasedOnId != null) {

            return new ResponseEntity<>(studentDetailsBasedOnId, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> deleteStudentBasedOnId(@PathVariable int studentId) {


        String message = studentService.deleteStudent(studentId);

        if (message.equals("student deleted")) {

            return ResponseEntity.ok(message);
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping("/students")
    public ResponseEntity<String> saveStudent(@RequestBody StudentEntity studentEntity) {

        String message = studentService.createStudent(studentEntity);

        if (message.equals("student created")) {

            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable int studentId, @RequestBody StudentEntity student) {

        StudentEntity studentData = studentService.updateStudent(studentId, student);
        if (studentData != null) {
            return new ResponseEntity<>(studentData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
