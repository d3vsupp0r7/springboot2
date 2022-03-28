package org.lba.springboot2.mybatis;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@PropertySource(ignoreResourceNotFound=true,value="classpath:dbconfig.properties")
public class MyBatisJavaConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisJavaConfig.class);
	/**/
	@Value("${db.driver}")
	private String driver;
	@Value("${db.url}")
	private String dbUrl;
	@Value("${db.username}")
	private String dbUsername;
	@Value("${db.password}")
	private String dbPass;

	@Bean
	public DataSource getDataSource() {
		/**/
		LOGGER.debug("*** LOADING DATASOURCE ***");
		PooledDataSource ds = new PooledDataSource();

		ds.setDriver(driver);
		ds.setUrl(dbUrl);
		ds.setUsername(dbUsername);
		ds.setPassword(dbPass);

		return ds;
	}

	@Bean
	public SqlSessionFactory getSessionFactory() throws IOException {
		/**/
		SqlSessionFactory sessionFactory  = null;
		/**/
		TransactionFactory trFact = new JdbcTransactionFactory();
		Environment environment = new Environment("development", trFact, getDataSource());
		/**/
		Properties prop = new Properties();
		prop.setProperty("driver", driver);
		prop.setProperty("url", dbUrl);
		prop.setProperty("user", dbUsername);
		prop.setProperty("password", dbPass);
		/**/
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration(environment);
		/**/
		PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setConfiguration(config);
		bean.setDataSource(getDataSource());
		bean.setMapperLocations(pathM3R.getResources("classpath*:mybatis/**/*.xml"));
		 try {
			 sessionFactory  = bean.getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return sessionFactory ;
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(getSessionFactory());
	}
}
