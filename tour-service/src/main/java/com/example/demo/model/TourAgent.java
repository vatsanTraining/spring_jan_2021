package com.example.demo.model;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class TourAgent {

	
	private int id;
	private String agentName;
	private long mobileNumber;
	
	
	public TourAgent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TourAgent(int id, String agentName, long mobileNumber) {
		super();
		this.id = id;
		this.agentName = agentName;
		this.mobileNumber = mobileNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "TourAgent [id=" + id + ", agentName=" + agentName + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
	
}
