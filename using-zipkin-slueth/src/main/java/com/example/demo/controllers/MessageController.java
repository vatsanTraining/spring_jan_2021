package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.MessageService;

@RestController
public class MessageController {

	
	@Autowired
	private MessageService service;



	 @GetMapping("/message")
	 public String getOneMessage() {
		 
		 return this.getOneMessage();
	 }

}
