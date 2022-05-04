package org.lba.springboot.kafka.controller;

import java.util.List;
import java.util.Optional;

import org.lba.springboot.kafka.db.model.Employee;
import org.lba.springboot.kafka.service.EmployeeRestServiceImpl;
import org.lba.springboot.kafka.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestControllerImpl implements EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeRestServiceImpl.class);

	@Autowired
	private EmployeeService employeeService;

	//C
	@Override
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.debug("Employee: " + employee.toString());
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
	@PutMapping("/{id}")
	public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	//D
	@Override
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable long id) {
		
		employeeService.deleteEmployeeById(id);

	}
	
}