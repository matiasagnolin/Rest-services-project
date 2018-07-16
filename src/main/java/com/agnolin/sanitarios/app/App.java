package com.agnolin.sanitarios.app;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.sanitarios.services.*","com.agnolin.sanitarios.controllers.*","com.agnolin.sanitarios.model.*"})
@ComponentScan(basePackageClasses= com.agnolin.sanitarios.controllers.ProductController.class)
@ComponentScan(basePackageClasses= com.agnolin.sanitarios.services.ProductService.class)
@ComponentScan(basePackageClasses= com.agnolin.sanitarios.repository.GenericHibernateDao.class)
public class App {

	public static void main (String []args){
		ApplicationContext context = SpringApplication.run(App.class, args);
		
	        System.out.println("Contains A  "+context.
	                containsBeanDefinition("ProductService"));
	        System.out.println("Contains B2  " + context.
	                containsBeanDefinition("ProductController"));
	        
	       
		
	}
	
	   @Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.agnolin.sanitarios.repository" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	 
	      return em;
	   }
	 
	   @Bean
	   public DataSource dataSource(){
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://localhost:3310/mysql_innodb_cluster_metadata");
	      dataSource.setUsername( "root" );
	      dataSource.setPassword( "root" );
	      return dataSource;
	   }
	 
	   @Bean
	   public PlatformTransactionManager transactionManager(
	     EntityManagerFactory emf){
	       JpaTransactionManager transactionManager = new JpaTransactionManager();
	       transactionManager.setEntityManagerFactory(emf);
	 
	       return transactionManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	       return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   Properties additionalProperties() {
	       Properties properties = new Properties();
	       properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	       properties.setProperty(
	         "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        
	       return properties;
	   }

}
