package com.authorizationservice.authorization.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserCredentialsTest {

	  private UserCredentials userCredentials = new UserCredentials("amit4", "amit4");

	   @Test
	   @DisplayName("Checking for AuthenticationResponse - if it is loading or not")
	   public void loadUserCredentials(){
	       assertThat(userCredentials).isNotNull();
	   }
	   
	   @Test
		void userCredentialsPositive() {
		    UserCredentials userCredentials = new UserCredentials("amit4", "amit4");
			assertEquals("amit4", userCredentials.getUsernName());
			assertEquals("amit4", userCredentials.getPassword());
		}
	   @Test
		void userCredentialsNegative() {
		    UserCredentials userCredentials = new UserCredentials("amit4", "amit4");
			assertNotEquals("amit", userCredentials.getUsernName());
			assertNotEquals("amit", userCredentials.getPassword());
		}
}
