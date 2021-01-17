package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Review;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {


	
	@Autowired
	private Review review;
	
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping(path = "/reviews")
	public Review getReview() {
		
		
		int portNumber = Integer.parseInt(port);
		
		review.setId(portNumber);
		review.setName("Ramesh");
		review.setRating(4.5);
		
		return review;
	}
	
}
