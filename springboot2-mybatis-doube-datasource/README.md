# Error 1

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-03-27 21:31:47.139 ERROR 16240 --- [  restartedMain] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Field sqlSession in org.lba.springboot2.placeholders.Springboot2PlaceholdersMyBatisApplication required a single bean, but 2 were found:
	- getSqlSession: defined by method 'getSqlSession' in class path resource [org/lba/springboot2/placeholders/MyAppConfig.class]
	- sqlSessionTemplate: defined by method 'sqlSessionTemplate' in class path resource [org/mybatis/spring/boot/autoconfigure/MybatisAutoConfiguration.class]


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

