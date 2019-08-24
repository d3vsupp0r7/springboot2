package org.lba.springboot2;

import java.util.Arrays;

import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.db.model.Qualification;
import org.lba.springboot2.db.repository.EmployeeRepository;
import org.lba.springboot2.db.repository.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToMany implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private QualificationRepository qualificationRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToMany.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/**/
		Employee employee1 = new Employee("EmployeeName_1", "EmployeeSurname_1");
		Employee employee2 = new Employee("EmployeeName_2", "EmployeeSurname_2");
		/**/

		/**/
		Qualification masters = new Qualification("Masters Degree");
		masters.setEmployees(Arrays.asList(employee1,employee2));
		Qualification savedQualification = qualificationRepository.save(masters);
		//
		System.out.println("Saved qualification: " + savedQualification.getId());
		System.out.println("Employee of qualification: " + savedQualification.getEmployees().get(0).getId());

	}
}
