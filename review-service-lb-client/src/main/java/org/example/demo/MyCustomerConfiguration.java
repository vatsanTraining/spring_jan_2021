package org.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
