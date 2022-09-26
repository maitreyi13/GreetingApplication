package com.greetingapplication.service;
import com.greetingapplication.model.GreetEntity;
import com.greetingapplication.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<GreetEntity> findById(int id) {
        return repository.findById(id);
    }
    public List<GreetEntity> findAllGreet(){
        return repository.findAll();
    }
    public GreetEntity editGreeting(GreetEntity greeting, int id) {
        GreetEntity existingGreet = repository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setMessage(greeting.getMessage());
            return repository.save(existingGreet);
        }
        else
            return null;
    }
}