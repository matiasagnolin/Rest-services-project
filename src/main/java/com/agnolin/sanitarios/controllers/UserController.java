package com.agnolin.sanitarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
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
	@Qualifier("UserServices")
	private IService<User> service;

	
	 @RequestMapping(value = "/New",method = RequestMethod.POST) 
     @ResponseStatus(value = HttpStatus.CREATED) 
     public void create(@DTO(UserDto.class) User user) { 
		 service.create(user); 
     }
	 
	@RequestMapping(value = "/Update", method = RequestMethod.PUT) 
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@DTO(UserDto.class) User user) { 
       service.update(user); 
    }
	
	@RequestMapping(value = "/",method = RequestMethod.GET) 
    @ResponseBody 
    public List<User> test() { 
		 return this.service.getAll(); 
    }
	

	public void setProductService(IService<User> service) {
		this.service = service;
	}
	
//	
//	    @GetMapping
//	    @PreAuthorize("hasAuthority('read:contacts')")
//	    public List<User> getContacts() {
//	        return contacts;
//	    }
//
//	    @PostMapping
//	    @PreAuthorize("hasAuthority('add:contacts')")
//	    public void addContact(@RequestBody User contact) {
//	        contacts.add(contact);
//	    }

}
