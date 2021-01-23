package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TourAgentService;

import java.util.*;
import com.example.demo.entity.*;

@RestController
public class TourAgentController {

	
	
	@Autowired
	private TourAgentService service;


	@GetMapping(path = "/api/v1/agents")
	public List<TourAgent> getAll(){
		
		return this.service.getAll();
	}

	@GetMapping(path = "/api/v1/agents/{id}")
	public TourAgent getAgentById(@PathVariable("id") int id){
		
		return this.service.getById(id).orElseThrow(()-> new RuntimeException("Element Not Found"));
		
	}
	
	
}
