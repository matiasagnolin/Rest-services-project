package com.agnolin.sanitarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.agnolin.sanitarios.interfaces.IRepository;
import com.agnolin.sanitarios.interfaces.IService;
import com.agnolin.sanitarios.model.User;


@Component("UserServices")
@Service
public class UserServices implements IService<User>{

	private IRepository<User> userRepository;
	
	//private ApplicationContext contextApp;
	
	
	@Override
	public void create(User user){
		userRepository.create(user);
		
	}

	@Override
	public void update(User user) {
		userRepository.update(user);	
	}
	


	public IRepository<User> getProductRepository() {
		return userRepository;
	}


	@Autowired
	public void setUserRepository(IRepository<User> dao) {
		this.userRepository=dao;
		this.userRepository.setClazz(User.class);
		this.userRepository.count();
	}


	@Override
	public List<User> getAll() {
		List<User> list = this.userRepository.findAll();
		return list;
	}
}
