package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Customer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class UsingElkApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsingElkApplication.class, args);
	}
	@Bean
	public Customer ramesh() {
		
		log.info("Customer Ramesh Created");
		return new Customer(110,"Ramesh Patil",4505050);
	}
}
