package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name="synetouragent")
@Slf4j
public class TourAgent {

	
	@Id
	private int id;
	private String agentName;
	private long mobileNumber;
	
	
	public TourAgent() {
		super();
		
		log.info("Tour Agent Initialized");
	}
	public TourAgent(int id, String agentName, long mobileNumber) {
		super();
		
		log.info("Tour Agent Initialized");
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
