package com.example.sprningboote;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "employeeEntityManagerFactory", transactionManagerRef = "employeeTransactionManager", basePackages = {
		"com.example.sprningboote.itcomp" })
public class EmployeeDataSourceCofig {

	@Bean(name = "employeeDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.employee")
	public DataSource employeeDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "employeeEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("employeeDataSource") DataSource employeeDataSource) {
		HashMap<String, Object> properties = new HashMap<>();
//		properties.put("spring.jpa.hibernate.ddl-auto", "create");
//		properties.put("spring.jpa.generate-ddl", "true");
		return entityManagerFactoryBuilder.dataSource(employeeDataSource).packages("com.example.sprningboote.itcomp")
				.properties(properties).persistenceUnit("employee").build();
	}

	@Bean(name = "employeeTransactionManager")
	@Primary
	public PlatformTransactionManager employeeTransactionManager(
			@Qualifier("employeeEntityManagerFactory") LocalContainerEntityManagerFactoryBean builder) {
		return new JpaTransactionManager(builder.getObject());
	}

}
