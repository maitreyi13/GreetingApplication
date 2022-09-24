package com.greetingapplication.controller;
import com.greetingapplication.model.GreetEntity;
import com.greetingapplication.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greet")
public class GreetingApp {

    @RequestMapping(value = {"","/","/home"}, method = RequestMethod.GET)
    public String greet(){
        return "<h1>Welcome to BridgeLabz</h1>";
    }

    @RequestMapping("/query/{name}")
    public String greet1(@PathVariable String name){
        return "<h1><font color=blue>Hello! This is " + name + " From BridgeLabz!!</font></h1>" +
                "</br> <font color=green>Passing name as a path variable.</font>";
    }

    @GetMapping("/query")
    public String getUsers(@RequestParam(value = "name", defaultValue = "Mark") String name) {
        return "<h1><font color=red>Hello! This is " + name + " From BridgeLabz!!</font></h1>" +
                "</br> <font color=green>Passing name as a parameter.</font>";
    }

    //Getting Greeting message from the Service layer
    @Autowired
    ServiceClass service;
    @GetMapping("/service")
    public String serviceCall(){
        return service.helloWorld();
    }
    //Ability for the Greeting App to give Greeting message
    @GetMapping("/user")
    public String greetMessageWithUser(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return service.greetMessageWithUser(firstName, lastName);
    }
    @PostMapping("/post")
    public GreetEntity addGreeting(@RequestBody GreetEntity greetings) {
        service.saveMessage(greetings);
        return greetings;
    }
    @GetMapping("/greetById/{id}")
    public Optional<GreetEntity> greetById(@PathVariable int id){
        return service.findById(id);
    }
    //get all the data
    @GetMapping("/allGreetings")
    public List<GreetEntity> findAllGreetings() {
        return service.findAllGreet();
    }
}