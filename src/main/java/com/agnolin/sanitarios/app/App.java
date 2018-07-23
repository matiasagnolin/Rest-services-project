package com.agnolin.sanitarios.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;





@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.agnolin.sanitarios.controllers","com.sanitarios.services"})
@EntityScan(basePackages= {"com.agnolin.sanitarios.model"})


public class App {

	public static void main (String []args){
		ApplicationContext context = SpringApplication.run(App.class, args);
		
	        System.out.println("Contains A  "+context.
	                containsBeanDefinition("ProductService"));
	}
	

}
