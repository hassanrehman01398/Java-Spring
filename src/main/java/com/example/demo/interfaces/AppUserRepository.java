/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.interfaces;

import com.example.demo.models.appUser;
import com.example.demo.models.student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hassan
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<student, Long> {
    
   // @Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<appUser> findUserByEmail(String email);

}
