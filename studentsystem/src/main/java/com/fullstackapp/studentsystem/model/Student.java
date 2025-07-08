package com.fullstackapp.studentsystem.model; // This package defines entities/beans, getters and setters

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Student {
    @Id // this is to make the id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is for auto generation of id
    private int id;
    private String name;
    private String address;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
