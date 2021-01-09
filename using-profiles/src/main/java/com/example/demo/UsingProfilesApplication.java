package com.example.demo;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.example.demo.model.Customer;

@SpringBootApplication
public class UsingProfilesApplication {

	

	
	public static void main(String[] args) {
	// ConfigurableApplicationContext ctx =	SpringApplication.run(UsingProfilesApplication.class, args);
	
	
		String desiredProfile ="dev";
		
		Properties props = new Properties();
        
	
		props.put("spring.profiles.active", desiredProfile);
		        

		
		ConfigurableApplicationContext ctx = 
				
				    new SpringApplicationBuilder(UsingProfilesApplication.class).properties(props).
				    build().run(args);
	
		
		Customer cust = ctx.getBean(Customer.class);
		
		
		System.out.println(cust);
		
	}

}

