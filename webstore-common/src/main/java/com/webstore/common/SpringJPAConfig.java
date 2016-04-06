package com.webstore.common;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration // declare the class as a Spring Java Configuration class
@EnableJpaRepositories(basePackages = { "com.webstore.common.repository.jpa" })
@PropertySource("classpath:common.properties")
public class SpringJPAConfig {

	private static final String PROPERTY_DEBUGGING = "debugging";
	// Data source properties
	private static final String PROPERTY_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_DATABASE_URL = "db.url";
	private static final String PROPERTY_DATABASE_USERNAME = "db.username";

	// Hikari CP properties
	private static final String PROPERTY_HIKIRI_DATASOURCE_MAX_POOL_SIZE = "hikari.datasource.max_pool_size";
	// Hibernate properties
	private static final String PROPERTY_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	
	private static final String PROPERTY_DOMAIN_PACKAGE = "domain.package";
	
	@Resource
	private Environment env;

	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		final HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(env.getRequiredProperty(PROPERTY_DATABASE_DRIVER));
		ds.setJdbcUrl(env.getRequiredProperty(PROPERTY_DATABASE_URL));
		ds.setUsername(env.getRequiredProperty(PROPERTY_DATABASE_USERNAME));
		ds.setPassword(env.getRequiredProperty(PROPERTY_DATABASE_PASSWORD));
		//max poolSize
		ds.setMaximumPoolSize(Integer.valueOf(env
				.getRequiredProperty(PROPERTY_HIKIRI_DATASOURCE_MAX_POOL_SIZE)));
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);

		Properties jpaProperties = new Properties();
		jpaProperties.put(PROPERTY_HIBERNATE_DIALECT,
				env.getRequiredProperty(PROPERTY_HIBERNATE_DIALECT));
		jpaProperties.put(PROPERTY_HIBERNATE_HBM2DDL_AUTO,
				env.getRequiredProperty(PROPERTY_HIBERNATE_HBM2DDL_AUTO));
		jpaProperties.put(PROPERTY_HIBERNATE_NAMING_STRATEGY,
				env.getRequiredProperty(PROPERTY_HIBERNATE_NAMING_STRATEGY));
		jpaProperties.put(PROPERTY_HIBERNATE_SHOW_SQL,
				env.getRequiredProperty(PROPERTY_HIBERNATE_SHOW_SQL));
		jpaProperties.put(PROPERTY_HIBERNATE_FORMAT_SQL,
				env.getRequiredProperty(PROPERTY_HIBERNATE_FORMAT_SQL));

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(env.getRequiredProperty(PROPERTY_DOMAIN_PACKAGE));
		factory.setDataSource(dataSource());
		factory.setJpaProperties(jpaProperties);
		
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		final JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		JpaDialect jpaDialect = new HibernateJpaDialect();
		txManager.setJpaDialect(jpaDialect);
		
		return txManager;
	}
}
