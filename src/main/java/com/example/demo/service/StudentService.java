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
import javax.transaction.Transactional;
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

    public void deleteStudent(Long id) {
        
    
    
       boolean studentById= studentRepository.existsById(id);
       if(!studentById){
       
       throw  new IllegalStateException("student not present");
       } 
       studentRepository.deleteById(id);
    }
@Transactional
    public void updateStudent(Long id, String name, String email) {
  
    
       boolean studentById= studentRepository.existsById(id);
       if(!studentById){
       
       throw  new IllegalStateException("student not present");
       }
    student Student=  studentRepository.findById(id).orElseThrow(() -> {
           return null; 
    });
       
       Student.setEmail(email);
      Student.setName(name);
    }
}

