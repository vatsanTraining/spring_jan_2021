package com.example.demo.client;

import org.springframework.context.annotation.Bean;

import feign.auth.BasicAuthRequestInterceptor;

public class SecurityConfig {

	
	
	@Bean
	public BasicAuthRequestInterceptor interceptor() {
		
		return new BasicAuthRequestInterceptor("india","india");
	}
}
