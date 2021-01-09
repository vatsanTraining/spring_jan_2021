package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.example.demo.model.Tour;
import com.example.demo.model.TourAgent;
import com.example.demo.model.TourCatalog;
import com.example.demo.utils.MyCustomAutoConfiguration;

@Configuration

public class ApplicationConfiguration {

	
	
	@Bean
	@Primary

	public Tour lankaTour() {
		
		return new Tour(101,"Colombo",56000);
	}
	

	
	@Bean
	@ConditionalOnProperty(name = "spring.application.name",havingValue = "asia")
	public TourAgent agentRam() {
		
		return new TourAgent(1033,"Ram",7484848);
		
	}
	@Bean
	@Conditional(MyCustomAutoConfiguration.class)
	public Tour thailand() {
		
		return new Tour(102,"thailand",86000);
	}
	
	@Bean
	@ConditionalOnProperty(name = "spring.application.name",havingValue = "aus")
	public TourAgent agentShyam() {
		
		return new TourAgent(1035,"Shyam",4548423);
		
	}
	
	@Bean
	public TourAgent agentManish() {
		
		return new TourAgent(2035,"Manish",3548423);
		
	}
	@Bean
	public Tour swiss() {
		
		 return new Tour(294, "Switzerland", 24500);
	}
	
	@Bean(name="swiss")
	public TourCatalog  swissTour(@Qualifier("swiss") Tour tour,@Qualifier("agentManish") TourAgent agent) {
		
		return new TourCatalog(tour,agent);
	}
	
	@Bean(name="africaBean")
	public TourCatalog  africa(@Qualifier("aft") Tour tour , @Qualifier("afa")  TourAgent agent) {
		
		return new TourCatalog(tour,agent);
	}
	
}
