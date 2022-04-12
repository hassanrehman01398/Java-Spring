/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.interfaces.StudentRepository;
import com.example.demo.models.student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hassan
 */
@Service
public class StudentService {
    private final StudentRepository studentRepository;
@Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
           public List<student> getStudents(){
          
            
        return   studentRepository.findAll();
          
        
        }

    public void addNewStudent(student Student) {
        
        
       Optional<student> studentByEmail= studentRepository.findStudentByEmail(Student.getEmail());
       if(studentByEmail.isPresent()){
       
       throw  new IllegalStateException("email taken");
       } 
       studentRepository.save(Student);
    }

    public void deleteStudent(int id) {
        System.out.println("id");
        System.out.println(id);
       Long longnum=Long.valueOf(id);
        
    
    
       boolean studentById= studentRepository.existsById(longnum);
       if(!studentById){
       
       throw  new IllegalStateException("student not present");
       } 
       studentRepository.deleteById(longnum);
    }
}

