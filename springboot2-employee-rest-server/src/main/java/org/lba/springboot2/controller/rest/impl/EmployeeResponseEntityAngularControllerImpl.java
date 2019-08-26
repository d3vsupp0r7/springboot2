package org.lba.springboot2.controller.rest.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.exceptions.ResourceNotFoundException;
import org.lba.springboot2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee-angular")
public class EmployeeResponseEntityAngularControllerImpl {

	static final Logger logger = Logger.getLogger(EmployeeResponseEntityAngularControllerImpl.class);

	@Autowired
	private EmployeeService employeeService;

	//C
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.debug("Employee: " + employee.toString());
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return savedEmployee;
	}
	//R
	@GetMapping("/all")
	public List<Employee> findAll() {
		logger.debug("employee-angular - findAll - called");
		return employeeService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id) 
			throws ResourceNotFoundException{

		Optional<Employee> employee = employeeService.findById(id);
		if (!employee.isPresent()) {
			logger.error("Id " + id + " is not existed");
			throw new ResourceNotFoundException("Employee not found for this id: " + id);
		}

		return ResponseEntity.ok().body(employee.get());
	}

	//U
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employeeUpdate) 
			throws ResourceNotFoundException{

		Optional<Employee> employee = employeeService.findById(id);
		
		if (!employee.isPresent()) {
			logger.error("Id " + id + " is not existed");
			throw new ResourceNotFoundException("Employee not found for this id: " + id);
		}
		
		Employee employeeFromDb = employee.get();
		/**/
		employeeFromDb.setName(employeeUpdate.getName());
		employeeFromDb.setSurname(employeeUpdate.getSurname());
		/**/
		Employee savedEmployee =  employeeService.updateEmployee(id, employeeFromDb);

		return ResponseEntity.ok(savedEmployee);
	}

	//D
	@DeleteMapping("/{id}")
	public Map<String, Boolean>  deleteEmployeeById(@PathVariable long id) 
			throws ResourceNotFoundException {

		Optional<Employee> employee = employeeService.findById(id);
		
		if (!employee.isPresent()) {
			logger.error("Id " + id + " is not existed");
			throw new ResourceNotFoundException("Employee not found for this id: " + id);
		}
		
		employeeService.deleteEmployeeById(id);
		
	    Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
	}

}
