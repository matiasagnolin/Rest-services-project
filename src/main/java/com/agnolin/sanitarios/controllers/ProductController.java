package com.agnolin.sanitarios.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agnolin.sanitarios.dto.ProductDto;
import com.agnolin.sanitarios.interfaces.IService;





@RestController
@RequestMapping("/Products")
public class ProductController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IService<ProductDto> service;///only controller should work with dto; anything else should work with the entity
	
	 
	 @RequestMapping(value = "/New",method = RequestMethod.POST) 
     @ResponseStatus(value = HttpStatus.CREATED) 
     public void create(@RequestBody ProductDto productDto) { 
		 service.create(productDto); 
     }
	 
	@RequestMapping(value = "/Modify", method = RequestMethod.POST) 
    @ResponseStatus(value = HttpStatus.OK) 
    public void update(@RequestBody ProductDto productDto) { 
       service.update(productDto); 
    }
	
	@RequestMapping(value = "/",method = RequestMethod.POST) 
    @ResponseStatus(value = HttpStatus.CREATED) 
    public void test() { 
		 System.out.println("debug here !!!"); 
    }
}
