package com.agnolin.com.agnolin.sanitarios;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.agnolin.sanitarios.model.User;
import com.agnolin.sanitarios.services.UserServices;

@RunWith(JUnit4.class)
public class ServiceTest  {
	
	@Autowired
	UserServices service;
	
	User user;
	
	@Before
	public void Initialize() {
		user= new User("Matias", "Agnolin","123");
		
	}
	
	@Test
	public void test() {
		
		Assert.isTrue(true);
	}

}
