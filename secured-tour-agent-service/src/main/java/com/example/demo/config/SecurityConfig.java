package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	PasswordEncoder encode;
	
	
	@Autowired
	DataSource dataSource;
	
	@Value("${security.enabled}")
	private String isPermitAll;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.inMemoryAuthentication()
//		         .withUser("india")
//		             .password(encode.encode("india"))
//		                 .roles("ADMIN");
		
		
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
                "SELECT username, password, enabled from users where username = ?")
            .authoritiesByUsernameQuery(
                "SELECT u.username, a.authority " +
                "FROM authorities a, users u " +
                "WHERE u.username = ? " +
                "AND u.username = a.username"
            )
        .passwordEncoder(new BCryptPasswordEncoder());

		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 System.out.println("==========="+ isPermitAll);
		 
		 if(isPermitAll.equals("true")) {
		  
//			 http.authorizeRequests()
//	      .antMatchers("/api/v1/agents/**")
//		         .authenticated().and().formLogin()
//		           .and().logout().logoutSuccessUrl("/api/v1/agents")
//		                .invalidateHttpSession(true).deleteCookies("JSESSIONID");
//		    
		    http.authorizeRequests()
		      .antMatchers("/api/v1/agents/**")
		         .authenticated().and().httpBasic()
		           .and().logout().logoutSuccessUrl("/api/v1/agents")
		                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
		                      .and().csrf().disable();
		
		    
		 } else {
		   
		 
		   
		
		    http.authorizeRequests()
		    .antMatchers("/**")
		     .permitAll();
		 }
	}

	
	@Bean
	public PasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
}


