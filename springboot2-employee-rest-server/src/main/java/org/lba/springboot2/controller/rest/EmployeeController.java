package org.lba.springboot2.controller.rest;

import java.util.List;

import org.lba.springboot2.db.model.Employee;


public interface EmployeeController {

	//C
	public Employee saveEmployee(Employee employee);

	//R
	public List<Employee> findAll();

	public Employee findById(Long id);

	//U
	public Employee updateEmployeeById(Long id, Employee employee);

	//D
	public void deleteEmployeeById(long id);
}
