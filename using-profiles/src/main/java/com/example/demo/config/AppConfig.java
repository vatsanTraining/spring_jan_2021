package com.example.demo.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;


import com.example.demo.model.Customer;

@Configuration
public class AppConfig {

	
	
	
	
	
	
	@Bean
	@Profile(value = "dev")
	public Customer ram() {
		
		return new Customer(1010, "Ram-dev");
	}
	
	
	   @Bean
	   @Profile(value = "prod")
       public Customer shyam() {
		
		return new Customer(2010, "Shyam-prod");
	}
	
	
}
