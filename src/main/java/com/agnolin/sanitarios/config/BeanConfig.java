package com.agnolin.sanitarios.config;



import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.agnolin.sanitarios.interfaces.IRepository;
import com.agnolin.sanitarios.model.Product;
import com.agnolin.sanitarios.model.User;
import com.agnolin.sanitarios.repository.GenericHibernateDao;
import com.agnolin.sanitarios.services.ProductService;
import com.agnolin.sanitarios.services.UserServices;

@PropertySource(value="classpath:application.properties")
@Configuration
//@EnableJpaRepositories(basePackages="com.agnolin.sanitarios.repository")
public class BeanConfig {
	
	@Autowired
	Environment env;

	@Bean 
	public ProductService ProductService(){
		return new ProductService();
				
	}
	@Bean 
	public UserServices UserServices(){
		return new UserServices();
				
	}
	
	@Bean 
	public IRepository<User> GenericHibernateDaoUser(){
		return new GenericHibernateDao<>();
	}
	
	@Bean 
	public IRepository<Product> GenericHibernateDaoProduct(){
		return new GenericHibernateDao<>();
	}
	

}
