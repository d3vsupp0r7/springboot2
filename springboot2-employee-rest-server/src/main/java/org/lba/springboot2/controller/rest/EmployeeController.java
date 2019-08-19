package org.lba.springboot2.controller.rest;

import java.util.List;

import org.lba.springboot2.db.model.Employee;

public interface EmployeeController {

	//C
	
	//R
	 public List<Employee> findAll();
	
	 public Employee findById(Long id);
	 
	//U
	
	//D
}
