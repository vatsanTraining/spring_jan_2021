package com.example.demo.filters;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class MyZuulFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		 
		RequestContext ctx = RequestContext.getCurrentContext();
		    HttpServletRequest request = ctx.getRequest();
		    System.out.println("REQUEST METHOD: " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
		
		    System.out.println(ctx.get("authorization"));
		    
//		     if(ctx.getRequest().getRequestURI().contains("customer")) {
//		          ctx.setResponseStatusCode(400);
//		          ctx.setResponseBody("Zuul is preventing");
//		          ctx.setSendZuulResponse(false);
//		          }
		    
//			HttpServletRequest req = ctx.getRequest();
//			Optional<String> authorizationHeader = Optional.ofNullable(req.getHeader("Authorization"));
//
//			 System.out.println("Header ======"+ authorizationHeader.get());

		    return null;
		
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
