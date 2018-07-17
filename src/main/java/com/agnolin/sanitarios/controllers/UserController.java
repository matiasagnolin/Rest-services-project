package com.agnolin.sanitarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.agnolin.sanitarios.dto.UserDto;
import com.agnolin.sanitarios.interfaces.IService;
import com.agnolin.sanitarios.model.User;
import com.agnolin.sanitarios.util.DTO;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private IService<User> service;///only controller should work with dto; everything else should work with the entity
	
	
	 
	 @RequestMapping(value = "/New",method = RequestMethod.GET) 
     @ResponseStatus(value = HttpStatus.CREATED) 
     public void create(@DTO(UserDto.class) User user) { 
		 
		 service.create(user); 
     }
	 
	@RequestMapping(value = "/Modify", method = RequestMethod.POST) 
    @ResponseStatus(value = HttpStatus.OK) 
    public void update(@DTO(UserDto.class) User user) { 
       service.update(user); 
    }
	
	@RequestMapping(value = "/",method = RequestMethod.POST) 
    @ResponseBody 
    public List<User> test() { 
		 return this.service.getAll(); 
    }
	

	public void setProductService(IService<User> service) {
		this.service = service;
	}

}
