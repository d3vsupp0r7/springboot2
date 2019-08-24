package org.lba.springboot2.controller.ui.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationControllerUIImpl {


	@GetMapping( {"/","/home"})
	public String home() {
		return "/home";
	}
	
	@GetMapping("/about")
	public String about() {
		return "/about";
	}
}
