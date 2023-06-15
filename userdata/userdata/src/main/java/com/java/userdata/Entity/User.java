package com.java.userdata.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "amazonUsers")
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
   
    
    @Column(nullable = false, unique = true, length = 45)
    private String username;
    
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
     
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    
    private String uniqueId;
}