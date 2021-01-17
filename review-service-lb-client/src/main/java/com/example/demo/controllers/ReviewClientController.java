package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class ReviewClientController {

	
	@Autowired
	private RestTemplate template;
	
	
	@GetMapping(path = "/client/reviews")
	public String fetchReviews() {
		
		
	  String reqURL = "http://review-client/reviews";
	  
	  return this.template.getForObject(reqURL,String.class);
	}
}
