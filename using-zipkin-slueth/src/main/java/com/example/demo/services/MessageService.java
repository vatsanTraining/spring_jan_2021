package com.example.demo.services;

import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessageService {

	
	public String  getBirthDayGreeting() {
		
		log.info("Birthday Greeting in Message Service Called");
		
		return "Happy Birthday";
	}
	
	@NewSpan(name = "weddingday")
	public String getWeddingDayGreeting() {
		
		log.info("Wedding Day  Greeting in Message Service Called ======");
		
		String message = getBirthDayGreeting();
		
		return "Happy Wedding Anniversary"+message;
	}
	@ContinueSpan()
	public String getDiwaliGreeting() {
		
		log.info("Diwali Greeting in Message Service Called *****");

		return "Happy Diwali";
	}
}
