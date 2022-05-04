package com.cognizant.proxy;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.bean.AuthenticationRequest;
import com.cognizant.bean.LoginModel;
import com.cognizant.dto.AuthenticationResponseDTO;
import com.cognizant.dto.ValidatingDTO;




//@FeignClient(name = "authorization-service", url="http://13.57.30.36:8081/auth")
@FeignClient(name = "authorization-service", url="http://localhost:8008/authorization")
public interface AuthProxy {

	
//	@PostMapping("/login")
//	public AppUser login(@RequestBody AppUser appUserloginCredentials);
	
	@PostMapping(value = "/login")
	public AuthenticationResponseDTO login(LoginModel loginModel);
	
//	@GetMapping("role/{id}")
//	public AuthenticationRequest getRole(@PathVariable("id") String id);
	
    @GetMapping(value = "/validate")
    public ValidatingDTO getsValidity(@RequestHeader(name = "Authorization", required = true) String token);
   
    @GetMapping("/getrole/{username}")
    public AuthenticationRequest getRole(@PathVariable("username") String username);
	
	
	
}
