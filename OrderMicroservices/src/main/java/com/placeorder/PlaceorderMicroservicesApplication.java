package com.placeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableFeignClients
@EnableDiscoveryClient
public class PlaceorderMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceorderMicroservicesApplication.class, args);
	}

}
