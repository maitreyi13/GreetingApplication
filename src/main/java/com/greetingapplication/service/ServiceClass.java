package com.greetingapplication.service;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    public String helloWorld() {
        return "Hello World! :D";
    }

    public String greetMessageWithUser(String firstName, String lastName) {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return helloWorld();
        } else if (lastName.equals("")) {
            return "Hello " + firstName + ", Welcome to the BridgeLabz!";
        } else if (firstName.equals("")) {
            return "Hello " + lastName + ", Welcome to the BridgeLabz!";
        }
        return "Hello " + firstName +" "+ lastName + ", Welcome to the BridgeLabz!";
    }
}