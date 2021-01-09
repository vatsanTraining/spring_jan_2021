package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.config.ApplicationConfiguration;
import com.example.demo.model.Tour;
import com.example.demo.model.TourCatalog;


//@ComponentScan(basePackages = "org.example.demo")
@SpringBootApplication
public class TourServiceApplication {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext ctx	=SpringApplication.run(TourServiceApplication.class, args);
	          
	                        	
//	     Tour tour =(Tour)ctx.getBean("tour");  // class Name with FirstCharacter in lower case
	     
//	       tour.setTourId(102);
//	       tour.setTourName("diu");
//	       tour.setAmount(45000.00);
	       
//	     System.out.println(tour);
//	     
//	     // get me a bean of NAME OR ID lankaTour
//
//	     Tour lanka = (Tour)ctx.getBean("lankaTour");
//	     
//	     System.out.println(lanka);
//	     
//	     // get me a bean of TYPE TOUR.class
//	     
//	     Tour nextTour = ctx.getBean("lankaTour",Tour.class);
//	     
//	     System.out.println(nextTour);
	     

	    TourCatalog catalog = ctx.getBean("catalog",TourCatalog.class);
	    
	    
	    
	    System.out.println(catalog);
	     
	     ctx.close();
	
	}

}
