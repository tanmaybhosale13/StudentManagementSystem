package com.example.annotations.Student_Management_System.bean;

import org.springframework.stereotype.Component;

@Component
public class EagerLoadingBean {

    public EagerLoadingBean() {
        System.out.println("eager loading bean object created");
    }
}
