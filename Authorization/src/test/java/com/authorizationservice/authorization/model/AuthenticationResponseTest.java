package com.authorizationservice.authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootApplication
public class AuthenticationResponseTest
{
   private AuthenticationResponse authenticationResponse = new AuthenticationResponse("adyasha", "token","admin");

   @Test
   @DisplayName("Checking for AuthenticationResponse - if it is loading or not")
   public void authenticationResponseNotNullTest(){
       assertThat(authenticationResponse).isNotNull();
   }
   
   @Test
	void testUserTokenAllArgs() {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("adyasha", "token","admin");
		assertEquals("adyasha", authenticationResponse.getUserName());
		assertEquals("token", authenticationResponse.getJwtAuthToken());
	}
}
