package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Customer;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class CustomerController {

	
	
	@Autowired
	private Customer customer;
	
	
	@GetMapping(path = "/api/v1/customers")
	public Customer getCustomer() {
		
		log.info("Get Customer Called");
		return this.customer;
	}
	
	
	@GetMapping(path = "/api/v1/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) throws InterruptedException {
		
		if(id < 7) {
			log.info("Get Customer By Id Less than 7 Called");

			return this.customer;
		   
		} else {
			
			Thread.sleep(7000);
			log.info("Get Customer By Id Greater than 7 Called");
			this.customer.setCustomerName("Delayed Customer");
			 
			return this.customer;
			
		}
	}
}
