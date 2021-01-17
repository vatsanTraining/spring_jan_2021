package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.ifaces.ProductRepository;

@RestController
public class ProductController {

	
	@Autowired
	private ProductRepository repo;


	
	@GetMapping(path = "/api/v1/products")
	public List<Product> getProduct(){
		
		
		return this.repo.findAll();
	}


}
