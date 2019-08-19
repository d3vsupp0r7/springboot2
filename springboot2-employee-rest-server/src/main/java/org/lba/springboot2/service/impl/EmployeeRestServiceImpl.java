package org.lba.springboot2.service.impl;

import java.util.List;

import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.db.repository.EmployeeRepository;
import org.lba.springboot2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRestServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

}
