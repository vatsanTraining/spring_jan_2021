package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TourClientController {

	
	private RestTemplate template;

	String baseURL = "http://localhost:6060/api/v1/tours/";

	@Autowired
	public void setTemplate(RestTemplate template) {
		this.template = template;
	}
	
	
	@GetMapping(path = "/api/v1/client/tours")
	public String invokeTourRestAPI() {
		
		
		return this.template.getForObject(baseURL, String.class);
		
		
	}
	
	
	@GetMapping(path = "/api/v1/client/tours/{tourId}")
	public String invokeTourFindById(@PathVariable("tourId") int id) {
		
		String reqURL = baseURL+id;
		return this.template.getForObject(reqURL, String.class,id);
		
		
	}
}
