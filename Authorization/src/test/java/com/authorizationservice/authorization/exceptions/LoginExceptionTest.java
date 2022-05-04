package com.authorizationservice.authorization.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginExceptionTest {

	LoginException exception = new LoginException("Exception");

	@Test
	@DisplayName("Checking if [Login Exception] is loading or not.")
	 void LoginExceptionIsLoaded() {
		assertThat(exception).isNotNull();
	}
}
