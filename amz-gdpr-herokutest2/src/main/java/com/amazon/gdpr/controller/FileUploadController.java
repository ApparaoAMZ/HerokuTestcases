package com.amazon.gdpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.amazon.gdpr.view.GDPRInput;

/****************************************************************************************
 * This controller is the GDPR Anonymization Load UI page 
 * This will be loaded everytime the user clicks on the Upload Anonymization 
 ****************************************************************************************/
@Controller
public class FileUploadController {
		
	@GetMapping("/uploadFile")
	public String uploadAnonymizationForm(Model model) {
		model.addAttribute("uploadFile", new GDPRInput());
		return "uploadFile";
	}

}
