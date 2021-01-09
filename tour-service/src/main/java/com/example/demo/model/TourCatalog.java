package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "catalog")
public class TourCatalog {

	
	private Tour tour;
	private TourAgent agent;
	
	public TourCatalog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@Autowired
	public TourCatalog(Tour tour, TourAgent agent) {
		super();
		this.tour = tour;
		this.agent = agent;
	}
	public Tour getTour() {
		return tour;
	}
	@Autowired(required = false)
	//@Qualifier(value = "thailand")
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public TourAgent getAgent() {
		return agent;
	}
	@Autowired
	public void setAgent(TourAgent agent) {
		this.agent = agent;
	}
	@Override
	public String toString() {
		return "TourCatalog [tour=" + tour + ", agent=" + agent + "]";
	}
	
	
	
	
}
