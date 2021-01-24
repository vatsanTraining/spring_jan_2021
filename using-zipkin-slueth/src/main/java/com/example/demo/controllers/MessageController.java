package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.MessageService;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MessageController {

	
	@Autowired
	Tracer tracer;
	
	@Autowired
	private MessageService service;



	 @GetMapping("/message")
	 public String getOneMessage() {
			log.info("Get One  Message in Controller Called ======");

		 return this.service.getBirthDayGreeting();
	 }
	 @GetMapping("/two")
	 public String getTwoMessage() {
			log.info("Get Two  Message in Controller Called ======");

		 return this.service.getWeddingDayGreeting();
	 }
}
