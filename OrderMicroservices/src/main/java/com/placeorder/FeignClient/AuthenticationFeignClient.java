package com.placeorder.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.placeorder.dto.AuthenticationResponseDTO;
import com.placeorder.dto.ValidatingDTO;
import com.placeorder.model.AuthenticationRequest;
//import com.placeorder.model.AuthenticationResponse;
import com.placeorder.model.LoginModel;

@FeignClient(name="auth-ms",url="${feign.url-auth-microservices}")
public interface AuthenticationFeignClient {

//	@GetMapping("/validateToken") 
//	public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token); 
//	
//	@GetMapping("/role/{id}")  
//	public String getRole(@PathVariable("id") String id);
//	
//	@GetMapping("/{id}") 
//	public AppUser getUserById(@PathVariable String Id);
	
	

	@PostMapping(value = "/login")
	public AuthenticationResponseDTO login(LoginModel loginModel);
	
    @GetMapping(value = "/validate")
    public ValidatingDTO getsValidity(@RequestHeader(name = "Authorization") String token);
   
    @GetMapping("/getrole/{username}")
    public AuthenticationRequest getRole(@PathVariable("username") String username);
}
