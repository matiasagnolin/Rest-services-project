package com.agnolin.sanitarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agnolin.sanitarios.interfaces.IRepository;
import com.agnolin.sanitarios.interfaces.IService;
import com.agnolin.sanitarios.model.Sell;

@Component("SellServices")
@Service
@RequestMapping("/Sells")
public class SellServices implements IService<Sell>{

	private IRepository<Sell> sellRepository;
	
	@Override
	public void create(Sell entity) {

		
	}

	@Override
	public List<Sell> getAll() {

		return null;
	}

	@Override
	public void update(Sell entity) {

		
	}
	
	public void calculateTotal() {
		
		
	}
	
	@Autowired
	public void setSellRepository(IRepository<Sell> dao) {
		this.sellRepository=dao;
		this.sellRepository.setClazz(Sell.class);
		this.sellRepository.count();
	}

}
