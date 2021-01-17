package com.example.demo;

import org.example.demo.MyCustomerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "review-client",configuration = MyCustomerConfiguration.class)
public class ReviewServiceLbClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceLbClientApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		
		return new RestTemplate();
	}
}
