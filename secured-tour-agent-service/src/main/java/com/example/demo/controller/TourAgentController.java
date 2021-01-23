package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TourAgentService;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import com.example.demo.entity.*;

@RestController
@Slf4j
public class TourAgentController {

	
	
	@Autowired
	private TourAgentService service;


	@GetMapping(path = "/api/v1/agents")
	public List<TourAgent> getAll(){
		log.info("Tour Agen Controller - getAll Method Invoked");
		return this.service.getAll();
	}

	@GetMapping(path = "/api/v1/agents/{id}")
	public TourAgent getAgentById(@PathVariable("id") int id){
		log.info("Tour Agen Controller - getAgentById Method Invoked");

		return this.service.getById(id).orElseThrow(()-> new RuntimeException("Element Not Found"));
		
	}
	
	
}
