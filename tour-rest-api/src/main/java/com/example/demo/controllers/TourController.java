package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.TourService;
import java.util.*;
import com.example.demo.model.*;
@RestController
public class TourController {
	
	
	
	@Autowired
	private TourService service;

	
	@GetMapping(path = "/api/v1/tours")
	public List<Tour> getAllTours(){
		
		return this.service.findAll();
	}
	
	
	@PostMapping(path = "/api/v1/tours")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tour addTour(@RequestBody Tour entity) {
		
		return this.service.addTour(entity);
	}
	
	
}
