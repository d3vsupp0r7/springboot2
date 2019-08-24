package org.lba.springboot2;

import org.lba.springboot2.db.model.Address;
import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.db.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class OneToOneApp implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// Create a new Employee
		Employee employee = new Employee("EmployeeName_1", "EmployeeSurname_1");
		//
		Address address = new Address("Street_1","City_1");
		//
		employee.setAddress(address);
		address.setEmployee(employee);
		//
		Employee savedEmployee = employeeRepository.save(employee);
		
		System.out.println("Saved employee: " + savedEmployee.getId());
		System.out.println("Saved employee: " + savedEmployee.getAddress().getCity());
		
	}

}
