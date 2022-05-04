package com.cts.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
@EnableFeignClients
@EnableDiscoveryClient
//@EnableCaching 
public class InventoryMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMicroservicesApplication.class, args);
	}

}
