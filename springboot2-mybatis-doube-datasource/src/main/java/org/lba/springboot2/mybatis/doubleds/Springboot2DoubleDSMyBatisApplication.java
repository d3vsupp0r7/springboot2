package org.lba.springboot2.mybatis.doubleds;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.lba.springboot2.mybatis.doubleds.db.model.EmployeeModel;
import org.lba.springboot2.mybatis.doubleds.db.repository.EmployeeRepository;
import org.lba.springboot2.mybatis.doubleds.db2.model.ManagerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot2DoubleDSMyBatisApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Springboot2DoubleDSMyBatisApplication.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	/**/
	
	@Autowired
	@Qualifier("dbSessionFactory2")
	SqlSessionFactory sqlSessionFactory2;
	
	@Autowired
	@Qualifier("dbSqlSession2")
	SqlSession sqlSession2;
	
	public static void main(String[] args) {
		SpringApplication.run(Springboot2DoubleDSMyBatisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		/**/
		LOGGER.debug("** DB 1 - READ - START **");
		List<EmployeeModel> list = sqlSession.selectList("findAllRecord");
		LOGGER.debug("\tSize: " + list.size());
		/**/
		LOGGER.debug("** DB 1 - READ - END **");
		
		/************************/
		/**/
		LOGGER.debug("** DB 2 - READ - START **");
		List<ManagerModel> listManager = sqlSession2.selectList("findAllManagerRecord");
		LOGGER.debug("\tSize: " + listManager.size());
		/**/
		LOGGER.debug("** DB 2 - READ - END **");
		
	}

}
