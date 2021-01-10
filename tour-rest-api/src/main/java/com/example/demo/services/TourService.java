package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tour;
import com.example.demo.repos.TourRepository;

@Service
public class TourService {

	
	
	@Autowired
	private TourRepository repo;
	
	
	public List<Tour> findAll(){
		
		
		return this.repo.findAll();
	}
	
	public Tour addTour(Tour entity) {
		
		return this.repo.save(entity);
	}
	
	public Optional<Tour> findById(int id) {
		
		return this.repo.findById(id);
	}
	
	
      public Tour updateTour(Tour entity) {
		
		return this.repo.save(entity);
				
      }
	
      public Tour findByName(String tourName) {
    	  
    	  return this.repo.findByTourName(tourName);
      }
      
      
      
      public List<Tour> tourGreaterThan(double amount){
    	  
    	  return this.repo.findTourGreathanFare(amount);
      }
}
