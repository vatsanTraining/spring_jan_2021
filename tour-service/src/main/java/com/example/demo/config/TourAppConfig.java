package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Tour;
import com.example.demo.model.TourAgent;

@Configuration
public class TourAppConfig {

	
	@Bean(name = "aft")
	public Tour africa() {
		
		 return new Tour(2949, "African Safari", 124500);
	}
	
	@Bean(name = "afa")
	public TourAgent africaAgent() {
		
		return new TourAgent(2035,"Manish",3548423);
		
	}
}
