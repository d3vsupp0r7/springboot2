package org.lba.springboot2.controller.ui.impl;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.lba.springboot2.controller.rest.impl.EmployeeRestControllerImpl;
import org.lba.springboot2.controller.ui.EmployeeControllerUI;
import org.lba.springboot2.controller.ui.form.EmployeeForm;
import org.lba.springboot2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeUIControllerImpl implements EmployeeControllerUI {

	static final Logger logger = Logger.getLogger(EmployeeUIControllerImpl.class); 
	
	@Autowired
	private EmployeeService employeeService;
	
	//C
	@GetMapping("/form")
	public String showForm(Model model) {

		model.addAttribute("employee", new EmployeeForm());
		return "employeeForm";
	}

	@PostMapping("/submit")
	public String submitForm( @ModelAttribute("employee") @Valid EmployeeForm employeeForm, BindingResult bindingResult, Model model ) {

		logger.debug("Form: " + employeeForm.toString());
		
		if (bindingResult.hasErrors()) {
			return "employeeForm";
		}
		
		

		return "employeeList";
	}
	
	//R
	@GetMapping("/all")
	public String listEmployees(Model model) {

		return "employeeList";
	}
}
