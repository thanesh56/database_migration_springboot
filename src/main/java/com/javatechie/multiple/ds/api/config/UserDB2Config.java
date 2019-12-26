package com.javatechie.multiple.ds.api.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userdb2EntityManagerFactory", transactionManagerRef = "userdb2TransactionManager", basePackages = {
		"com.javatechie.multiple.ds.api.userdb2.repository" })
public class UserDB2Config {

	@Bean(name = "userdb2DataSource")
	@ConfigurationProperties(prefix = "spring.userdb2.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "userdb2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userdb2EntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("userdb2DataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return builder.dataSource(dataSource).properties(properties)
				.packages("com.javatechie.multiple.ds.api.model.user").persistenceUnit("User").build();
	}

	@Bean(name = "userdb2TransactionManager")
	public PlatformTransactionManager userdb2TransactionManager(
			@Qualifier("userdb2EntityManagerFactory") EntityManagerFactory userdb2EntityManagerFactory) {
		return new JpaTransactionManager(userdb2EntityManagerFactory);
	}
}
