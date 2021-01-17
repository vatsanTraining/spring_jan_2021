package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Product;
import com.example.demo.ifaces.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			private ProductRepository repo;
			@Override
			public void run(String... args) throws Exception {
		
				
				repo.save(new Product(101,"TV",45000.00));
				repo.save(new Product(102,"Fridge",35000.00));
					
			}
		};
	}
}
