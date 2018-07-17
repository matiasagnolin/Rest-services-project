package com.agnolin.sanitarios.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.agnolin.sanitarios.repository.GenericHibernateDao;
import com.agnolin.sanitarios.services.ProductService;
import com.agnolin.sanitarios.services.UserServices;

@PropertySource(value="classpath:application.properties")
@Configuration
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
	public GenericHibernateDao GenericHibernateDao(){
		return new GenericHibernateDao<>();
	}
	

}
