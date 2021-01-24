package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ClientCredentialsReactiveOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.InMemoryReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;



@Configuration
@Slf4j
public class WebClientConfig {

	@Bean
	public WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) 
	{
//        return WebClient.builder().filter(getOAuth2FilterFunction(clientRegistrations))
//	                                  .baseUrl(String.format("http://localhost:8585/api/v1/"))
//	                                  .build();

        return WebClient.builder().baseUrl("http://localhost:8585/api/v1/")
                .build();

	}
	
    

	
	    private ExchangeFilterFunction getOAuth2FilterFunction(
	    		ReactiveClientRegistrationRepository clientRegistrationRepository) {

	    		InMemoryReactiveOAuth2AuthorizedClientService authorizedClientService = 
	    				new InMemoryReactiveOAuth2AuthorizedClientService(
	    						 clientRegistrationRepository);
	    		
	    		AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager 
	    		   authorizedClientManager = 
	    		      new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
	    		    		    clientRegistrationRepository, authorizedClientService);
	    		
	    		authorizedClientManager.setAuthorizedClientProvider(
	    				 new ClientCredentialsReactiveOAuth2AuthorizedClientProvider());

	    		ServerOAuth2AuthorizedClientExchangeFilterFunction oauth2FilterFunction = 
	    				 new ServerOAuth2AuthorizedClientExchangeFilterFunction(
	    						  authorizedClientManager);
	    		
	    		oauth2FilterFunction.setDefaultClientRegistrationId("custom");
	    		
	    		return oauth2FilterFunction;
	    	}
	    
	    
	 }