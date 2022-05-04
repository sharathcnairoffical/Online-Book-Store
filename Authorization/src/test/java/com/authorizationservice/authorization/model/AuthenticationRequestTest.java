package com.authorizationservice.authorization.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootApplication
public class AuthenticationRequestTest
{
   @Autowired
   @Mock
   private AuthenticationRequest authenticationRequest = new AuthenticationRequest("adyasha", "adyasha","admin");

   @Test
   @DisplayName("Checking for AuthenticationRequest - if it is loading or not")
   public void authenticationRequestNotNullTest(){
       assertThat(authenticationRequest).isNotNull();
   }

	@Test
	void testUserLoginBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(AuthenticationRequest.class);
	}


	@Test
	void testUserTokenBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(AuthenticationResponse.class);
	}

	@Test
	void testUserTokenEqualsAndHashCode2() {
		EqualsVerifier.simple().forClass(AuthenticationResponse.class).verify();
	}

	@Test
	void testUserLoginAllArgs() {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("adyasha", "dummy","admin");
		assertEquals("adyasha", authenticationRequest.getUserName());
		assertEquals("dummy", authenticationRequest.getPassword());
	}

	
}
