package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.TourAgent;
import com.example.demo.repos.TourAgentRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SecuredTourAgentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredTourAgentServiceApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			private TourAgentRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
			
				log.info("CommandLine Runner Run Method Called");
				 repo.save(new TourAgent(101,"Ramesh", 949494));
				 repo.save(new TourAgent(102,"Manish", 749594));
				 
				
			}
		};
	}
}
