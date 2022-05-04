package com.authorizationservice.authorization;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorizationApplicationTests {

	@Autowired
	AuthorizationApplication authorizationApplication;
	
	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Test
	void AuthorizationApplicationTest() {
		assertThat(authorizationApplication).isNotNull();
	}
}
