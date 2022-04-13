/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import com.example.demo.service.StudentService;
import com.example.demo.models.student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hassan
 */

@RestController
@RequestMapping(path = "api/v1/student")
public class RegisterationController {
    
    private final StudentService studentService;  

@Autowired
    public RegisterationController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    
    @GetMapping
        public List<student> getStudents(){
            return studentService.getStudents();
        
        }
        
        @PostMapping
        public void registerNewStudent(@RequestBody student Student){
        
        studentService.addNewStudent(Student);
        }
        
        @DeleteMapping(path ="{studentId}")
        public void deleteStudent(@PathVariable("studentId") Long id){
studentService.deleteStudent(id);        
        }
        
         @PutMapping(path ="{studentId}")
        public void updateStudent(@PathVariable("studentId") Long id,@RequestParam(required = false) String name,@RequestParam(required = false) String email){
studentService.updateStudent(id,name,email);        
        }
}
