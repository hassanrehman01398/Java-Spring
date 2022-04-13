/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.interfaces.AppUserRepository;
import com.example.demo.interfaces.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hassan
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{

    private final AppUserRepository appUserRepository; 

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  
    return appUserRepository.findUserByEmail(username).orElseThrow(() -> 
    new UsernameNotFoundException("User not found with this email") );
    }
    
}
