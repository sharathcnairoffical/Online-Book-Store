package com.authorizationservice.authorization;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@OpenAPIDefinition
@SpringBootApplication
@EnableDiscoveryClient
public class AuthorizationApplication {

	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

	
	

}