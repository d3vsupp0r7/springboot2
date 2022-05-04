package org.lba.springboot.kafka.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.springboot.kafka.db.model.Employee;
import org.lba.springboot.kafka.db.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@Import(CreateEmployeeIntegrationTestConfig.class)
@TestPropertySource(locations="classpath:test-application.properties")
@EnableTransactionManagement
@ComponentScan({"org.lba.springboot.kafka"})
@EnableJpaRepositories("org.lba.springboot.kafka.db.repository")
@EntityScan("org.lba.springboot.kafka.db.model.*")
public class CreateEmployeeIntegrationTest {
	
	Logger LOGGER = LoggerFactory.getLogger(CreateEmployeeIntegrationTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private Environment env;
	
	@Autowired
	private EmployeeRepository repo;
	
	@Test
	public void printContextBean() {

		LOGGER.debug("*** CreateEmployeeIntegrationTest - printContextBean - START ***");
		String[] beans = applicationContext.getBeanDefinitionNames();
		LOGGER.debug("*** CreateEmployeeIntegrationTest - printContextBean - number of beans: " + beans.length);
		Arrays.sort(beans);
		int id = 1;
		for (String bean : beans) 
		{
			LOGGER.debug(id +") " + bean + " of Type :: " + applicationContext.getBean(bean).getClass());
			id++;
		}
		LOGGER.debug("*** CreateEmployeeIntegrationTest - printContextBean -   END ***");
	}

	@Test
	public void read() {

		LOGGER.debug("*** CreateEmployeeIntegrationTest - read - START ***");
		List<Employee> employee = repo.findAll();
		LOGGER.debug("*** CreateEmployeeIntegrationTest - read - START ***");
		
	}
		

}
