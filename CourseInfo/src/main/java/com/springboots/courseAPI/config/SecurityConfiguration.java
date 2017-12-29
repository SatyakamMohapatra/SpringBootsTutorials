package com.springboots.courseAPI.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//To provide hardcode authentication
		auth.inMemoryAuthentication().withUser("satya").password("satya").roles("USER").and()
									 .withUser("test").password("test").roles("ADMIN","USER");
		//Provide DB authentication
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/Hello/**").hasRole("ADMIN")
			.antMatchers("/**").hasRole("USER")
			.anyRequest()            //Accept any request
			.authenticated()
			//.fullyAuthenticated()  //With authentication
			//.permitAll()           //without authentication
			.and()
			.httpBasic();
		/*
		 * another way to control auth by using filter
		 */
//		http.authorizeRequests()
//		.anyRequest()//Accept any request
//		.fullyAuthenticated()
//		//.permitAll()           //without authentication
//		.and()
//		//.addFilterAfter(customFilter(),BasicAuthenticationFilter.class)
//		.httpBasic();
//		http.csrf().disable();
	}
	
	@Bean
	public Filter customFilter() {
		return new CustomFilter();
	}

}
