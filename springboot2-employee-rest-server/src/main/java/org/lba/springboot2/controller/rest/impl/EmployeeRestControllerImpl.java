package org.lba.springboot2.controller.rest.impl;

import java.util.List;
import java.util.Optional;

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

	//C
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return savedEmployee;
	}
	//R
	@Override
	@GetMapping("/all")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		
		 Optional<Employee> employee = employeeService.findById(id);
		 if (!employee.isPresent()) {
	            logger.error("Id " + id + " is not existed");
		 }
		 
		return employee.get();
	}
	
	//U
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//D
	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub

	}

}
