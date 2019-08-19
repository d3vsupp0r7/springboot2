package org.lba.springboot2.service;

import java.util.List;

import org.lba.springboot2.db.model.Employee;

public interface EmployeeService {

	//C
	public Employee saveEmployee(Employee employee);
	
	//R
	public List<Employee> findAll();
	
	public Employee findById(Long id);
	
	//U
	public Employee updateEmployee(Employee employee);
	
	//D
	public void deleteEmployeeById(long id);

}
