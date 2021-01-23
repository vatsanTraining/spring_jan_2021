package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	PasswordEncoder encode;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		         .withUser("india")
		             .password(encode.encode("india"))
		                 .roles("ADMIN");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		    http.authorizeRequests()
//		      .antMatchers("/api/v1/agents/**")
//		         .authenticated().and().formLogin()
//		           .and().logout().logoutSuccessUrl("/api/v1/agents")
//		                .invalidateHttpSession(true).deleteCookies("JSESSIONID");
//		   
		    
		   
		    http.authorizeRequests()
		      .antMatchers("/api/v1/agents/**")
		         .authenticated().and().httpBasic()
		           .and().logout().logoutSuccessUrl("/api/v1/agents")
		                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
		                      .and().csrf().disable();
		   
	}

	
	@Bean
	public PasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
}
