package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	PasswordEncoder encode;
	
	@Value("${security.enabled}")
	private String isPermitAll;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		         .withUser("india")
		             .password(encode.encode("india"))
		                 .roles("ADMIN");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 System.out.println("==========="+ isPermitAll);
		 
		 if(isPermitAll.equals("true")) {
		    http.authorizeRequests()
	      .antMatchers("/api/v1/agents/**")
		         .authenticated().and().formLogin()
		           .and().logout().logoutSuccessUrl("/api/v1/agents")
		                .invalidateHttpSession(true).deleteCookies("JSESSIONID");
		 } else {
		   
//		    http.authorizeRequests()
//		      .antMatchers("/api/v1/agents/**")
//		         .authenticated().and().httpBasic()
//		           .and().logout().logoutSuccessUrl("/api/v1/agents")
//		                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
//		                      .and().csrf().disable();
//		
		   
		
		    http.authorizeRequests()
		    .antMatchers("/**")
		     .permitAll();
		 }
	}

	
	@Bean
	public PasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
}
