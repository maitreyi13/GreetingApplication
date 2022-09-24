package com.greetingapplication.service;
import com.greetingapplication.model.GreetEntity;
import com.greetingapplication.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    @Autowired
    private Repo repository;
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
    public GreetEntity saveMessage(GreetEntity greetings) {
        repository.save(greetings);
        return greetings;
    }
}