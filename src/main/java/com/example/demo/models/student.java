/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.models;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Hassan
 */
@Entity
@Table
public class student {
    @Id
    @SequenceGenerator(
    name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
   @GeneratedValue(
   strategy = GenerationType.SEQUENCE,
           generator = "student_sequence"
   
   )
    private int id;
    private String name;
    private String email;


    private LocalDate dob;
    @Transient
    private int age;

    public student() {
    }
    
    
        public student( String name, String email, LocalDate dob) {
     
            this.name = name;
        this.email = email;
        this.dob = dob;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + '}';
    }
        
        
}
