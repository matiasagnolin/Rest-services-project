package com.agnolin.sanitarios.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agnolin.sanitarios.dto.ProductDto;
import com.agnolin.sanitarios.interfaces.IService;
import com.agnolin.sanitarios.model.Product;
import com.agnolin.sanitarios.util.DTO;





@RestController
@RequestMapping("/Products")
public class ProductController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("ProductService")
	private IService<Product> service;///only controller should work with dto; everything else should work with the entity
	
	
	 
	 @RequestMapping(value = "/New",method = RequestMethod.GET) 
     @ResponseStatus(value = HttpStatus.CREATED) 
     public void create(@DTO(ProductDto.class) Product product) { 
		 
		 service.create(product); 
     }
	 
	@RequestMapping(value = "/Modify", method = RequestMethod.POST) 
    @ResponseStatus(value = HttpStatus.OK) 
    public void update(@DTO(ProductDto.class) Product product) { 
       service.update(product); 
    }
	
	@RequestMapping(value = "/",method = RequestMethod.POST) 
    @ResponseStatus(value = HttpStatus.CREATED) 
    public void test() { 
		 System.out.println("debug here !!!"); 
    }
	

	public void setProductService(IService<Product> service) {
		this.service = service;
	}
}
