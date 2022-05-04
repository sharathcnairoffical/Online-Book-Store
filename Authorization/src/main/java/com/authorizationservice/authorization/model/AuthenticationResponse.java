package com.authorizationservice.authorization.model;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class AuthenticationResponse {

    
    private String userName;
    
   
    private String jwtAuthToken;
    private String role;


    
}
