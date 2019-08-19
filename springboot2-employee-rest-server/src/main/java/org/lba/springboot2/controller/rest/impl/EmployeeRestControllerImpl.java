package org.lba.springboot2.controller.rest.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.springboot2.controller.rest.EmployeeController;
import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestControllerImpl implements EmployeeController {

	static final Logger logger = Logger.getLogger(EmployeeRestControllerImpl.class);

	@Autowired
	private EmployeeService employeeService;


	@Override
	@GetMapping("/all")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}





}
