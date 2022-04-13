/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.models;

import com.example.demo.enums.AppUserRole;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Hassan
 */
//@Getter
//@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class appUser implements UserDetails {
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
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;

    public appUser(String name, String username, String email, String password, AppUserRole appUserRole, Boolean locked, Boolean enabled) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }
    private Boolean enabled;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
     }

    @Override
    public String getPassword() {
   return  password;
    }

    @Override
    public String getUsername() {
  return  username;
    }

    @Override
    public boolean isAccountNonExpired() {
return true;
    }

    @Override
    public boolean isAccountNonLocked() {
return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
 return  true;
    }

    @Override
    public boolean isEnabled() {
  return enabled;
    }
    
}
