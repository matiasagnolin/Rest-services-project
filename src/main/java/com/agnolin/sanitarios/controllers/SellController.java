package com.agnolin.sanitarios.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agnolin.sanitarios.interfaces.IService;
import com.agnolin.sanitarios.model.Product;

@RestController
public class SellController {

	
	@Autowired
	@Qualifier("ProductService")
	private IService<Product> service;
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @RequestMapping("/")
    String index(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        service.create(new Product());
        return "index";
    } 	
}
