/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Hassan
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegisterationRequest {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    
}
