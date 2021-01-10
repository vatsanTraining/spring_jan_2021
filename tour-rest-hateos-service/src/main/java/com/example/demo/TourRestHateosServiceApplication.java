package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.TourAgent;
import com.example.demo.repos.TourAgentRepository;

@SpringBootApplication

public class TourRestHateosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourRestHateosServiceApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {
			
			@Autowired
			TourAgentRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
			
				  repo.save(new TourAgent(101, "Shiv", 9494949));
				  repo.save(new TourAgent(102, "vikas", 9794949));
				  repo.save(new TourAgent(103, "rahul", 98494949));
				  
			}
		};
	}
}
