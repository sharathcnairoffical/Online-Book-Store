package com.authorizationservice.authorization.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class AuthRequestRepoTest {

	@Autowired
	AuthRequestRepo authRequestRepo;
	
	@Test
    @DisplayName("Checking if [AuthRequestRepo] is loading or not.")
    void authRequestRepoIsLoaded(){
        assertThat(authRequestRepo).isNotNull();    
    }
}
