package org.lba.springboot2.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.lba.springboot2.mybatis.db.model.EmployeeModel;
import org.lba.springboot2.mybatis.db.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot2MyBatisApplication_Read_App implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Springboot2MyBatisApplication_Read_App.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	public static void main(String[] args) {
		SpringApplication.run(Springboot2MyBatisApplication_Read_App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		/**/
		LOGGER.debug("Application load");
		List<EmployeeModel> list = sqlSession.selectList("findAllRecord");
		LOGGER.debug("Size: " + list.size());
		/**/
		LOGGER.debug("Application load");
		
	}

}
