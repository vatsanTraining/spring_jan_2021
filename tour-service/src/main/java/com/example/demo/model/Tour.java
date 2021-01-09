package com.example.demo.model;

import org.springframework.stereotype.Component;

// @Component Enables to Register the Bean 

public class Tour {

	private int tourId;
	private String tourName;
	private double amount;
	public Tour() {
		super();
	}
	public Tour(int tourId, String tourName, double amount) {
		super();
		this.tourId = tourId;
		this.tourName = tourName;
		this.amount = amount;
	}
	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Tour [tourId=" + tourId + ", tourName=" + tourName + ", amount=" + amount + "]";
	}
	
}
