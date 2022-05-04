package com.placeorder.model;



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


public class AuthenticationRequest {

    

    private String userName;

   
    private String password;
    
    private String role;

}
