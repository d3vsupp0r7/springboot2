package org.lba.springboot2.mybatis;

import org.lba.springboot2.mybatis.db.model.EmployeeModel;
import org.lba.springboot2.mybatis.db.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Springboot2Application_HibernateInsert_App implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application_HibernateInsert_App.class, args);
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
