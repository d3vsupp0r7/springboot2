package org.lba.springboot.kafka.tests;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.server.web.WebServlet;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.PlatformTransactionManager;

@TestConfiguration
@WebAppConfiguration
public class CreateEmployeeIntegrationTestConfig {

	@Autowired
	private Environment env;

	Logger LOGGER = LoggerFactory.getLogger(CreateEmployeeIntegrationTestConfig.class);

	private static final String H2_JDBC_URL_TEMPLATE = "jdbc:h2:mem:springboot;DB_CLOSE_DELAY=-1";

	@Value("classpath:META-INF/testdb/employee/employee-create-tables.sql")
	private Resource H2_SCHEMA_SCRIPT;

	@Value("classpath:META-INF/testdb/employee/employee-initial-load.sql")
	private Resource H2_DATA_SCRIPT;

	@Value("classpath:META-INF/testdb/employee/employee-clean-db.sql")
	private Resource H2_CLEAN_DB_SCRIPT;

	@Autowired
	private ResourceLoader resourceLoader;

	/* H2 Database Web console configuration */
	@Bean(name = "h2server", destroyMethod = "stop")
	public Server getH2Server() {
		Server h2Server;
		try {
			h2Server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8080");
			h2Server.start();
			return h2Server;
		} catch (SQLException e) {
			LOGGER.info("Fail to start H2 server.", e);
		}
		return null;
	}

	@Bean
	public ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
	/* H2 Datasource configuration */
	@Autowired
	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {

		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

	private DatabasePopulator databasePopulator() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(H2_CLEAN_DB_SCRIPT);
		populator.addScript(H2_SCHEMA_SCRIPT);
		populator.addScript(H2_DATA_SCRIPT);
		/*Add Springbtach tables*/
		Resource springBatch = resourceLoader.getResource("classpath:/org/springframework/batch/core/schema-h2.sql");
		populator.addScript(springBatch);
		/**/
		return populator;
	}

	@Bean
	public DataSource dataSource() {
		String jdbcUrl = String.format(H2_JDBC_URL_TEMPLATE, System.getProperty("user.dir"));
		JdbcDataSource ds = new JdbcDataSource();       
		ds.setURL(jdbcUrl);
		ds.setUser("sa");
		ds.setPassword("");

		return ds;
	}

	/* Database related configuration:  JPA*/
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "org.springframework.data.jpa.convert.threeten","org.lba.springboot.kafka.db.model" });
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean(name="transactionManager") 
	public PlatformTransactionManager platformTransactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	final Properties additionalProperties() {

		final Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto.config"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect.config"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql.config"));
		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
		hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));

		LOGGER.debug("*** CreateEmployeeIntegrationTestConfig - PROPERTIES HIBERNATE - START");
		for (Object key: hibernateProperties.keySet()) {
			LOGGER.debug("Key: " + key + " - Value: " + hibernateProperties.getProperty(key.toString()));
		}
		LOGGER.debug("*** CreateEmployeeIntegrationTestConfig - PROPERTIES HIBERNATE - END");

		return hibernateProperties;
	}

	/***********************************************/
	
}
