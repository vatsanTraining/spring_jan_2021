package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.TourService;
import java.util.*;
import com.example.demo.model.*;
@RestController
@RequestMapping(path = "/api/v1/tours")
public class TourController {
	
	
	
	@Autowired
	private TourService service;

	
	@GetMapping(path = "/")
	public List<Tour> getAllTours(){
		
		return this.service.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Tour> getTourById(@PathVariable("id") int id){
		
		Tour resp =this.service.findById(id).orElseThrow( () -> new RuntimeException("ID Not Found"));
		
		//return this.service.findById(id).orElseThrow( () -> new RuntimeException("ID Not Found"));
	
		 return ResponseEntity.ok().body(resp);
	
	}
	
	
	@PostMapping(path = "/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tour addTour(@RequestBody Tour entity) {
		
		return this.service.addTour(entity);
	}
	
	

@PutMapping(path = "/")
public Tour updateTour(@RequestBody Tour entity) {
	
	return this.service.updateTour(entity);
}

}