package org.lba.springboot2;

import java.util.Arrays;

import org.lba.springboot2.db.model.Department;
import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.db.repository.DepartmentRepository;
import org.lba.springboot2.db.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToOne implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToOne.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Department department = new Department("IT");
		/**/
		Employee employee1 = new Employee("EmployeeName_1", "EmployeeSurname_1");
		Employee employee2 = new Employee("EmployeeName_2", "EmployeeSurname_2");
		/**/
		department.setEmployees(Arrays.asList(employee1,employee2));
		/**/
		Department savedDepartment = departmentRepository.save(department);
		//
		System.out.println("Saved department: " + savedDepartment.getId());
		System.out.println("Employee of department: " + savedDepartment.getEmployees().get(0).getId());
		
	}
}
