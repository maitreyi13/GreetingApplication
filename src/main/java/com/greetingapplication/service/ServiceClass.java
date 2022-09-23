package com.greetingapplication.service;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    public String helloWorld(){
        return "<h1><font color=pink>Hello World!</font></h1>";
    }
}