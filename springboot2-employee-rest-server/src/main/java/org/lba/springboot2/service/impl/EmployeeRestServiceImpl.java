package org.lba.springboot2.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.db.repository.EmployeeRepository;
import org.lba.springboot2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRestServiceImpl implements EmployeeService {

	static final Logger logger = Logger.getLogger(EmployeeRestServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	//C
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	//R
	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(Long id) {

		return employeeRepository.findById(id);
	}

	//U

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		if (!result.isPresent()) {
			logger.error("Id " + id + " is not existed");
		}
		
		int status = employeeRepository.updateEmplyeeById(employee.getName(), employee.getSurname(),  result.get().getId() );
		logger.debug("Update status: " + status);
		
		return employeeRepository.findById(id).get();
	}

	//D
	@Override
	public void deleteEmployeeById(long id) {

		if (!employeeRepository.findById(id).isPresent()) {
			logger.error("Id " + id + " is not existed");
		}

		employeeRepository.deleteById(id);
	}

}
