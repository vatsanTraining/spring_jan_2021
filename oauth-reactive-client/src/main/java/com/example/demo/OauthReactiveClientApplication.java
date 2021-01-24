package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.web.reactive.function.client.WebClient;



@SpringBootApplication

public class OauthReactiveClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(OauthReactiveClientApplication.class, args);
		
		WebClient webClient = ctx.getBean(WebClient.class);
		
		webClient.get()
        .uri("/customers")
        .retrieve()
        .bodyToMono(String.class)
        .subscribe(s -> System.out.println(s));

	}

	
	}
