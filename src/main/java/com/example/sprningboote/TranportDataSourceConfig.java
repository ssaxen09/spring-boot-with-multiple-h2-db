package com.example.sprningboote;

import com.example.sprningboote.itcomp.Employee;
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

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "transportentityManagerBeanFactory", transactionManagerRef = "transportTraction", basePackages = {
		"com.example.sprningboote.transport" })
public class TranportDataSourceConfig {

	@Bean(name = "transportDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.transport")
	public DataSource transportDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "transportentityManagerBeanFactory")
	public LocalContainerEntityManagerFactoryBean transportEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("transportDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
//		properties.put("spring.jpa.hibernate.ddl-auto", "update");
//		properties.put("spring.jpa.generate-ddl", "true");
return builder.dataSource(dataSource)
				.packages("com.example.sprningboote.transport").persistenceUnit("transport").properties(properties).build();
	}

	@Bean(name = "transportTraction")
	public PlatformTransactionManager employeeTranscation(
			@Qualifier("transportentityManagerBeanFactory") LocalContainerEntityManagerFactoryBean bean) {
		return new JpaTransactionManager(bean.getObject());
	}
}
