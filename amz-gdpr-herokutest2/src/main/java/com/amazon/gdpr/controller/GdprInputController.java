package com.amazon.gdpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.amazon.gdpr.view.GDPRInput;

/****************************************************************************************
 * This controller is the GDPR Depersonalization UI page 
 * This will be loaded everytime the user clicks on the GDPR Depersonalization 
 ****************************************************************************************/
@Controller
public class GdprInputController {
	
	@GetMapping("/gdprInput")
	public String gdprInputForm(Model model) {
		model.addAttribute("gdprInput", new GDPRInput());
		return "gdprInput";
	}

	/*@PostMapping("/gdprInput")
	public String greetingSubmit(@ModelAttribute GDPRInputView gdprInputView, Model model) {
		model.addAttribute("gdprInputView", gdprInputView);
		return "result";
	}*/
}
