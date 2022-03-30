package org.lba.springboot2.mybatis.doubleds;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource(ignoreResourceNotFound=true,value="classpath:dbconfig.properties")
public class MyAppConfigJavaMyBatis {


	private static final Logger LOGGER = LoggerFactory.getLogger(MyAppConfigJavaMyBatis.class);

	@Value("classpath:META-INF/testdb/db1/clean-db.sql")
	private Resource H2_SCHEMA_DB1_CLEANER;

	@Value("classpath:META-INF/testdb/db1/schema.sql")
	private Resource H2_SCHEMA_DB1_SCRIPT;

	@Value("classpath:META-INF/testdb/db1/data.sql")
	private Resource H2_DATA_DB1_SCRIPT;

	/**/
	@Value("classpath:META-INF/testdb/db2/clean-db.sql")
	private Resource H2_SCHEMA_DB2_CLEANER;

	@Value("classpath:META-INF/testdb/db2/schema.sql")
	private Resource H2_SCHEMA_DB2_SCRIPT;

	@Value("classpath:META-INF/testdb/db2/data.sql")
	private Resource H2_DATA_DB2_SCRIPT;

	/**/
	@Value("${db.driver}")
	private String driver;
	@Value("${db.url}")
	private String dbUrl;
	@Value("${db.username}")
	private String dbUsername;
	@Value("${db.password}")
	private String dbPass;

	/**/
	@Value("${db.driver.second}")
	private String driverSecond;
	@Value("${db.url.second}")
	private String dbUrlSecond;
	@Value("${db.username.second}")
	private String dbUsernameSecond;
	@Value("${db.password.second")
	private String dbPassSecond;

	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	@Qualifier("db1")
	public DataSource getDataSource() {

		PooledDataSource ds = new PooledDataSource();

		ds.setDriver(driver);
		ds.setUrl(dbUrl);
		ds.setUsername(dbUsername);
		ds.setPassword(dbPass);


		return ds;
	}

	@Bean
	@Qualifier("dbSessionFactory1")
	@Primary
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

	@Primary
	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		/**/
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(additionalProperties());
		/**/

		emf.setPackagesToScan("org.lba.springboot2.mybatis.doubleds.db.model");
		emf.setPersistenceUnitName("default");   // <- giving 'default' as name
		emf.afterPropertiesSet();
		return emf.getObject();
	}

	@Bean
	JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") final EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");

		return hibernateProperties;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("db1") final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;

	}

	private DatabasePopulator databasePopulator() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(H2_SCHEMA_DB1_CLEANER);
		populator.addScript(H2_SCHEMA_DB1_SCRIPT);
		populator.addScript(H2_DATA_DB1_SCRIPT);
		/**/
		Resource springBatch = resourceLoader.getResource("classpath:/org/springframework/batch/core/schema-h2.sql");
		populator.addScript(springBatch);
		/**/
		return populator;
	}

	/****************************/
	@Bean
	@Qualifier("dbDataSource2")
	public DataSource getDataSource2() {

		PooledDataSource ds = new PooledDataSource();

		ds.setDriver(driverSecond);
		ds.setUrl(dbUrlSecond);
		ds.setUsername(dbUsernameSecond);
		ds.setPassword(dbPassSecond);

		return ds;
	}

	@Bean
	@Qualifier("dbSessionFactory2")
	public SqlSessionFactory getSessionFactory2() throws IOException {
		/**/
		SqlSessionFactory sessionFactory  = null;
		/**/
		TransactionFactory trFact = new JdbcTransactionFactory();
		Environment environment = new Environment("development", trFact, getDataSource2());
		/**/
		Properties prop = new Properties();
		prop.setProperty("driver", driverSecond);
		prop.setProperty("url", dbUrlSecond);
		prop.setProperty("user", dbUsernameSecond);
		prop.setProperty("password", dbUsernameSecond);
		/**/
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration(environment);
		/**/
		PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setConfiguration(config);
		bean.setDataSource(getDataSource2());
		bean.setMapperLocations(pathM3R.getResources("classpath*:mybatis/**/*.xml"));
		try {
			sessionFactory  = bean.getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sessionFactory ;
	}
	
	@Bean(name = "entityManagerFactory2")
	public EntityManagerFactory entityManagerFactory2() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource2());
		/**/
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(additionalProperties());
		/**/

		emf.setPackagesToScan("org.lba.springboot2.mybatis.doubleds.db2.model");
		emf.setPersistenceUnitName("default");   // <- giving 'default' as name
		emf.afterPropertiesSet();
		return emf.getObject();
	}

	@Qualifier("dbSqlSession2")
	@Bean
	public SqlSessionTemplate sqlSession2() throws Exception {
		return new SqlSessionTemplate(getSessionFactory2());
	}

	@Bean
	@Qualifier("dataSourceInitializer2")
	public DataSourceInitializer dataSourceInitializer2(@Qualifier("dbDataSource2") final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator2());
		return initializer;

	}

	private DatabasePopulator databasePopulator2() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(H2_SCHEMA_DB2_CLEANER);
		populator.addScript(H2_SCHEMA_DB2_SCRIPT);
		populator.addScript(H2_DATA_DB2_SCRIPT);
		/**/
		return populator;
	}
}
