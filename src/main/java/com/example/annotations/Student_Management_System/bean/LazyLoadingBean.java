package com.example.annotations.Student_Management_System.bean;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoadingBean {


    public LazyLoadingBean() {

        System.out.println("Lazy loading bean object created ");
    }
}
