package com.greetingapplication.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GreetEntity {
    String firstName;
    String lastName;
    @Id
    @GeneratedValue
    private int id;

    public GreetEntity(GreetEntity greetings)
    {
        this.firstName = greetings.firstName;
        this.lastName = greetings.lastName;

    }
    public GreetEntity()
    {

    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }


    public Integer getId()
    {
        return id;
    }
}