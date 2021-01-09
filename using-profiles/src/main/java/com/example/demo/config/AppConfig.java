package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.model.Customer;

@Configuration
public class AppConfig {

	
	
	@Bean
	@Profile(value = "dev")
	public Customer ram() {
		
		return new Customer(1010, "Ram");
	}
	
	
	   @Bean
	   @Profile(value = "prod")
       public Customer shyam() {
		
		return new Customer(2010, "Shyam");
	}
	
	
}
