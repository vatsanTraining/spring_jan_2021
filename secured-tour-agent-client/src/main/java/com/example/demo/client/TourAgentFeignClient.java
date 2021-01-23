package com.example.demo.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="client",url = "http://localhost:6565/api/v1",configuration = SecurityConfig.class)
public interface TourAgentFeignClient {

	
	@GetMapping(path = "/agents")
	public String getAll();
	
	
}
