package com.authorizationservice.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authorizationservice.authorization.exceptions.LoginException;
import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.repository.AuthRequestRepo;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Slf4j
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	AuthRequestRepo authRequestRepo;
	
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("BEGIN - [loadUserByUsername()]");
		log.debug(userName);
	  	UserDetails userDetails=null;
    	AuthenticationRequest authenticationRequest = authRequestRepo.findById(userName).orElse(null);
		if(authenticationRequest!=null) 
		{
			//userDetails = new User(authenticationRequest.getUserName(), authenticationRequest.getPassword(), (Collection<? extends GrantedAuthority>) new ArrayList<Object>());
			ArrayList<GrantedAuthority> grantedAuthorities=(ArrayList<GrantedAuthority>) AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+authenticationRequest.getRole());
			//ob.setRole();
			userDetails = new User(authenticationRequest.getUserName(), authenticationRequest.getPassword(), grantedAuthorities);
			
			log.debug("User : " + userDetails);
			log.info("User : " + userDetails);
			log.info("END - [loadUserByUsername()]");
		}		
		return userDetails;
    }
    
    @Transactional
    public AuthenticationRequest getRole(String username) {
    log.info("Inside getMovieItem service");
    Optional<AuthenticationRequest> auth = authRequestRepo.findById(username);
    log.info("Role "+ auth.get().getRole());



    AuthenticationRequest obj = auth.get();
    return obj;



    }

   
} 
  