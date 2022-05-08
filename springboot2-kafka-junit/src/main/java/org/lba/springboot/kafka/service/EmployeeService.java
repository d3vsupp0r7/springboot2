package org.lba.springboot.kafka.service;

import java.util.List;
import java.util.Optional;

import org.lba.springboot.kafka.db.model.Employee;

public interface EmployeeService {

	//C
	public Employee saveEmployee(Employee employee);

	//R
	public List<Employee> findAll();

	public Optional<Employee> findById(Long id);

	//U
	public Employee updateEmployee(Long id, Employee employee);

	//D
	public void deleteEmployeeById(long id);

}
