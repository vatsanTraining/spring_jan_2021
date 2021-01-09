package com.example.demo.utils;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyCustomAutoConfiguration implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		
		String portRef =context.getEnvironment().getProperty("server.port");
		
		log.info("SERVER PORT :="+ portRef);
		if(portRef.equals("8080")) {
		return false;
		} else {
			return true;
		}
		
		
	}

}
