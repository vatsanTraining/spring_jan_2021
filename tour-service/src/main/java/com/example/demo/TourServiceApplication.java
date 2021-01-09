package com.example.demo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;

import com.example.demo.config.ApplicationConfiguration;
import com.example.demo.model.Tour;
import com.example.demo.model.TourAgent;
import com.example.demo.model.TourCatalog;


//@ComponentScan(basePackages = "org.example.demo")
@SpringBootApplication
public class TourServiceApplication {

	public static void main(String[] args) {
		
	//ConfigurableApplicationContext ctx	=SpringApplication.run(TourServiceApplication.class, args);
	  
		 Properties props = new Properties();
         
            props.put("spring.main.allow-bean-definition-overriding", "true");
        
		ConfigurableApplicationContext ctx	=
				    new SpringApplicationBuilder(TourServiceApplication.class)
				            .properties(props).build().run(args);
	
	  
	                
	                        	
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
	     

//	    TourCatalog catalog = ctx.getBean("catalog",TourCatalog.class);
//	    
//	    
//	    
//	    System.out.println(catalog);
	
	//
	
	   Tour lankaTour = (Tour)ctx.getBean("lankaTour");
	   
	   System.out.println(lankaTour);
	   
	       System.out.println("is SingleTon : =" +ctx.isSingleton("lankaTour"));
	       
	       System.out.println("is Protype : =" +ctx.isPrototype("lankaTour"));
	       
	       
//	       TourAgent agent = ctx.getBean(TourAgent.class,"agentManish");
//	       
//	       System.out.println(agent);
	       
	       Tour tour = ctx.getBean(Tour.class,"thailand");
	       System.out.println("Thai Tour" +tour);
	       
//	       
//	       TourCatalog swiss = ctx.getBean(TourCatalog.class,"swissTour");
//	       
//	       System.out.println(swiss);
	       
	       
           TourCatalog africa = ctx.getBean(TourCatalog.class,"africaBean");
	       
	       System.out.println("Africa Tour"+africa);
	       
	       
	       
	       
	     ctx.close();
	
	}

}
