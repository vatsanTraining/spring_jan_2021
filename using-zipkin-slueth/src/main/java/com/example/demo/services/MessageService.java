package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	
	public String  getBirthDayGreeting() {
		
		return "Happy Birthday";
	}
	
	
	public String getWeddingDayGreeting() {
		
		return "Happy Wedding Anniversary";
	}
	
	public String getDiwaliGreeting() {
		
		
		return "Happy Diwali";
	}
}
