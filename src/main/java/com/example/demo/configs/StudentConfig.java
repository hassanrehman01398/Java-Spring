/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.configs;

import com.example.demo.interfaces.StudentRepository;
import com.example.demo.models.student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Hassan
 */
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
    return (args) -> {
        student hassan=new student("Hassan", "hassan@gmail.com", LocalDate.now(), 22);
        student usman=new student("Usman", "usman@gmail.com", LocalDate.now(), 22);
    
    studentRepository.saveAll(Arrays.asList(hassan,usman));
    };
  }
    
}
