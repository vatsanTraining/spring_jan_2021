package com.example.demo.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Tour;
import com.example.demo.model.TourAgent;

@Configuration

public class ApplicationConfiguration {

	
	
//	@Bean
//	@Primary
//	public Tour lankaTour() {
//		
//		return new Tour(101,"Colombo",56000);
//	}
//	

	
	@Bean
	public TourAgent tourAgent() {
		
		return new TourAgent(1033,"Ram",7484848);
		
	}
	@Bean
	public Tour thailand() {
		
		return new Tour(102,"thailand",86000);
	}
}
