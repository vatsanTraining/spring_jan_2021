package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MyCustomerConfiguration {

	
	 
	
	    @Bean
	    public IRule ribbonRule() {
	        
	 	 
	          IRule rule = new RoundRobinRule();
	               return rule;
	              
	    }


}
