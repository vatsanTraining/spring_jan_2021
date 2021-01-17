package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Customer;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

	
	
	@Autowired
	private Customer customer;
	
	
	@GetMapping(path = "/api/v1/customers")
	public Customer getCustomer() {
		
		
		return this.customer;
	}
	
	
	@GetMapping(path = "/api/v1/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) throws InterruptedException {
		
		if(id < 7) {
		   return this.customer;
		   
		} else {
			
			Thread.sleep(7000);
			
			this.customer.setCustomerName("Delayed Customer");
			 
			return this.customer;
			
		}
	}
}
