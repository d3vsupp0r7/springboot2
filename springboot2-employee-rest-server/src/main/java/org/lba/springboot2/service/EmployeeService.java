package org.lba.springboot2.service;

import java.util.List;

import org.lba.springboot2.db.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();

}
