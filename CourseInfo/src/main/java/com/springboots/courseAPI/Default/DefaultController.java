package com.springboots.courseAPI.Default;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * DefaultController
 */
@RestController
public class DefaultController {
	
	private DefaultController(){
		System.out.println("DefaultController Created");
	}
	
	/*
	 * defaultMethod to handel any HTTP Request
	 */
	@RequestMapping("/Hello")
	public String defaultMethod(@AuthenticationPrincipal final UserDetails details) {
		//Other way to restrict the method from accessing via role
		String username = details.getUsername();
		String password = details.getPassword();
		System.out.println("Login username: "+username+" password: "+password);
		Collection<? extends GrantedAuthority> authorities = details.getAuthorities();
		authorities.forEach(System.out::println);
		return "HI! PLEASE WELCOME TO THE COURSE-INFO";
	}
}
