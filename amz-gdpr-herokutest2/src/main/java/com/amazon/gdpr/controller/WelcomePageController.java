package com.amazon.gdpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/****************************************************************************************
 * This controller is the main page of the Heroku GDPR UI 
 * This will be called everytime the Heroku GDPR webapp is loaded
 ****************************************************************************************/
@Controller
public class WelcomePageController {
	/**
	 * This method gets called when the main page of the Heroku GDPR UI is called 
	 * @return  
	 */
	@RequestMapping("/")
	public String welcome(Model model) {
		System.out.println("WelcomeController :: welcome : Executing welcome");
		return "welcome";
	}
}