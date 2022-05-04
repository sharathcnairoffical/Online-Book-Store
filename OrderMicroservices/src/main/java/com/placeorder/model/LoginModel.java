package com.placeorder.model;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@ToString
@Component
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
	
	   
   
	private String userName;
	
	
	private String password;
	
	private String role;
}
