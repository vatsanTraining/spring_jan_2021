package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {

	
	
	@Autowired
	private RestTemplate template;
	
	
	String baseURL = "http://CUSTOMER-SERVICE/";
	
	
	@GetMapping(path = "/api/v1/client/customers")
	public String getCustomerDetails() {
		
	
		String reqURL = baseURL+"api/v1/customers";
		
		
		return this.template.getForObject(reqURL, String.class);
		
		
		
	}
}
