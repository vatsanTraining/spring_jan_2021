package com.example.demo;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.example.demo.config.AppConfig;
import com.example.demo.model.Customer;

@SpringBootApplication
public class UsingProfilesApplication {

	static String desiredProfile ="prod";

	static {
		

		String os =System.getProperty("os.name");

	
		if(os.contains("Windows 10")) {
		  desiredProfile ="dev";
		}

	}

	
	public static void main(String[] args) {
	// ConfigurableApplicationContext ctx =	SpringApplication.run(UsingProfilesApplication.class, args);
	
				Properties props = new Properties();
	
		props.put("spring.profiles.active", desiredProfile);
		        
	 				

		
		ConfigurableApplicationContext ctx = 
				
				    new SpringApplicationBuilder(UsingProfilesApplication.class).properties(props).
				    build().run(args);
	
		
		Customer cust = ctx.getBean(Customer.class);
		
		
		System.out.println(cust);
		
	}

	}

