package com.authorizationservice.authorization.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Getter
@Setter
@NoArgsConstructor      //need default constructor for JSON Parsing
@AllArgsConstructor
@ToString
@Entity

public class AuthenticationRequest {

    @Id
   
    private String userName;

    
    private String password;
    
    private String role;

}
