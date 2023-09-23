package com.example.annotations.Student_Management_System.config;


import com.example.annotations.Student_Management_System.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {



       @Bean
       public TestBean testBean(){

           return new TestBean();
       }



}
