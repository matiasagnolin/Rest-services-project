package com.agnolin.sanitarios.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.agnolin.sanitarios.interfaces.IRepository;
import com.agnolin.sanitarios.interfaces.IService;
import com.agnolin.sanitarios.model.Product;


@Component("ProductService")
@Service
public class ProductService implements IService<Product> {
	
	
	private IRepository<Product> productRepository;

	
	
	
	public void create(Product product){
		productRepository.create(product);
		
	}


	public void update(Product product) {
		productRepository.update(product);	
	}
	


	public IRepository<Product> getProductRepository() {
		return productRepository;
	}

	@Autowired
	public void setProductRepository(IRepository<Product> dao) {
		this.productRepository=dao;
		this.productRepository.setClazz(Product.class);
		this.productRepository.count();
	}


	@Override
	public List<Product> getAll() {
		List<Product> list = this.productRepository.findAll();
		return list;
	}

	

		
}
