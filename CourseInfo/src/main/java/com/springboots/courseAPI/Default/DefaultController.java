package com.springboots.courseAPI.Default;

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
	public String defaultMethod() {
		return "HI! PLEASE WELCOME TO THE COURSE-INFO";
	}
}
