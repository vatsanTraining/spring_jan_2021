package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

	
	
	@Autowired
	private RestTemplate template;
	
	
	@Autowired
	@Qualifier("lbtemplate")
	private RestTemplate lbtemplate;
	
	
	@Autowired
	private LoadBalancerClient  client;
	
	String baseURL = "http://CUSTOMER-SERVICE/";
	
	
	@GetMapping(path = "/api/v1/client/customers")
	public String getCustomerDetails() {
		
	
		String reqURL = baseURL+"api/v1/customers";
				
		
		return this.template.getForObject(reqURL, String.class);
		
		
	}
	
	
	@GetMapping(path = "/api/v1/client/customers/{id}")
	@HystrixCommand(fallbackMethod = "getCustomerByIdFallback",
	commandProperties = 
	  @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value="3000" ))
	public String getCustomerDetailsById(@PathVariable("id") int id) {
		
	
		String reqURL = baseURL+"api/v1/customers/"+id;
				
		
		return this.template.getForObject(reqURL, String.class);
		
		
	}
	
	public String getCustomerByIdFallback(int id){
		
		return "{'id':0,'name':'guest'}";
	}
	
	@GetMapping(path = "/api/v1/client/invoices")
	public String getInvoiceDetails() {
		
	
		ServiceInstance instance = client.choose("INVOICE-SERVICE");
		
		log.info("Load Balancer Client :="+ client.getClass().getName());
		
		
		String baseURL = instance.getUri().toString();
	
		
		log.info("BASE URL :="+baseURL);

		
		String reqURL = baseURL+"api/v1/invoices";
		
		
		return this.lbtemplate.getForObject(reqURL, String.class);
		
		
		
	}
	
}
