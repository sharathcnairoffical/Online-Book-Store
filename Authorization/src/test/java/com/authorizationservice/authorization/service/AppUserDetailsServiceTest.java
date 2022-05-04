package com.authorizationservice.authorization.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import com.authorizationservice.authorization.exceptions.LoginException;
import com.authorizationservice.authorization.model.AuthenticationRequest;
//import com.authorizationservice.authorization.model.ChangePassword;
import com.authorizationservice.authorization.repository.AuthRequestRepo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest(classes = AppUserDetailsService.class)
public class AppUserDetailsServiceTest {

    @MockBean
    private AuthRequestRepo userRepo;

    @Autowired
    private AppUserDetailsService userService;

    @Test
    @DisplayName("Checking for AppUserDetailsService - if it is loading or not")
    public void appUserDetailsServiceNotNullTest() {
        assertThat(userService).isNotNull();
    }
    
    @Test
    void testloadUserByUsername() {
        AuthenticationRequest user = new AuthenticationRequest("amit4", "amit4","admin");
        when(userRepo.findById("amit4")).thenReturn(Optional.of(user));
        UserDetails userDetails = new User("amit4", "amit4", new ArrayList<>());
        assertEquals(userDetails, userService.loadUserByUsername("amit4"));
        System.out.print(userService.loadUserByUsername("amit4").getUsername());
    }

    
   
}
