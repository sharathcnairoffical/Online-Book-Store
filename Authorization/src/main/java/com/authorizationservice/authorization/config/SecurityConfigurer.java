package com.authorizationservice.authorization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.headers().frameOptions().disable();
		httpSecurity.csrf().disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/**").permitAll()
				.antMatchers(HttpMethod.GET, "/**").permitAll()
				
				.anyRequest().authenticated().and()
				.exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                
		//httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
	
	
	
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.headers().frameOptions().disable();
//		httpSecurity.csrf().disable()
//				.authorizeRequests()
//				.antMatchers("/admin").hasRole("ADMIN")
//				.antMatchers("/user").hasAnyRole("ADMIN","USER")
//				.antMatchers("/").permitAll()
//				.anyRequest().authenticated().and()
//				.exceptionHandling().and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                
//		//httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//	}
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
}
