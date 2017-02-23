package com.shm.bcb.config;

import cn.fanciers.sth.infrastructure.persist.datasource.SthDbcpDataSourceBuilder;
import cn.fanciers.sth.infrastructure.persist.datasource.SthJpaEntityManagerFactoryBeanBuilder;
import cn.fanciers.sth.infrastructure.persist.datasource.SthJpaTransactionManagerBuilder;
import cn.fanciers.sth.infrastructure.persist.jpa.springdatajpa.SthJpaRepositoryFactoryBean;
import com.mysema.query.jpa.impl.JPAQueryFactory;
import com.shm.bcb.core.entity.BcbEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories( basePackageClasses = {BcbEntities.class },
	repositoryFactoryBeanClass = SthJpaRepositoryFactoryBean.class, transactionManagerRef = "transactionManager")
public class BcbCoreJpaRepositoryConfig {
	// for bean definition
	public static final String STH_JDBC_PROPERTIES_PREFIX = "bcb.mysql.jdbc";
	public static final String STH_PERSISTENCE_UNIT_NAME = "bcb";

	@Autowired
	private Environment environment;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		return new SthDbcpDataSourceBuilder(this.environment, STH_JDBC_PROPERTIES_PREFIX).build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		return new SthJpaEntityManagerFactoryBeanBuilder(this.environment).setDataSource(this.dataSource()).setPersistenceUnitName(
				STH_PERSISTENCE_UNIT_NAME).build();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new SthJpaTransactionManagerBuilder(this.environment).setEntityManagerFactory(entityManagerFactory).build();
	}

	@Bean
	public JPAQueryFactory jpaQueryFactory(Provider<EntityManager> entityManager) {
		return new JPAQueryFactory(entityManager);
	}

}
