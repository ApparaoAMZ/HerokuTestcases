package com.amazon.gdpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputDetailController {
		
	@RequestMapping("/inputDetails")
	public String inputDetails(Model model) {
		System.out.println("InputDetailsController :: inputDetails : Executing Input Details");
		/*InputDetailsVw view = dbAccessService.fetchInputDetails();
		model.addAttribute("users", view.userList);
		model.addAttribute("categories", view.categoryList);*/
		return "inputDetails";	
	}
}