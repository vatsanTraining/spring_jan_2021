package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.example.demo.domain.Customer;

@SpringBootApplication
@EnableResourceServer
public class OauthClientCredentialsGrantTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthClientCredentialsGrantTypeApplication.class, args);
	}

	@Bean
	public Customer ramesh() {
		
		return new Customer(110,"Ramesh Patil",4505050);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuditEventRepository auditEvent() {
		
		 return new InMemoryAuditEventRepository();
	}
}
