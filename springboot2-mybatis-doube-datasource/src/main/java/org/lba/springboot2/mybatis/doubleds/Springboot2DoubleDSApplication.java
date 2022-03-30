package org.lba.springboot2.mybatis.doubleds;

import org.lba.springboot2.mybatis.doubleds.db.model.EmployeeModel;
import org.lba.springboot2.mybatis.doubleds.db.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Springboot2DoubleDSApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Springboot2DoubleDSApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeModel model = new EmployeeModel();
		model.setName("Name");
		model.setSurname("Surname");
		model.setDepartmentcode("DeptCode");
		/**/
		employeeRepository.save(model);
		
	}

}
