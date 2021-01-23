package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repos.TourAgentRepository;


import lombok.extern.slf4j.Slf4j;

import com.example.demo.entity.*;

@Service
@Slf4j
public class TourAgentService {

	@Autowired
	private TourAgentRepository repo;


	
	public List<TourAgent> getAll(){
		
		log.info("getAll in Tour Agent Service Called");
		
		return this.repo.findAll();
	}
	
	
	public Optional<TourAgent>  getById(int id) {
		
		log.info("getById in Tour Agent Service Called");
		
		return this.repo.findById(id);
	}
	
	
}
