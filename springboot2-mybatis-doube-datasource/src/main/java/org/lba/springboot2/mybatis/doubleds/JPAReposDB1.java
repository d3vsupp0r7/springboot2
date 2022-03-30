package org.lba.springboot2.mybatis.doubleds;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = {"org.lba.springboot2.mybatis.doubleds.db.repository"}
        )
public class JPAReposDB1 {

}
