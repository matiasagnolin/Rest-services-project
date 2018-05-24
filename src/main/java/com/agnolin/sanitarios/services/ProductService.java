package com.agnolin.sanitarios.services;



import org.springframework.beans.factory.annotation.Autowired;

import com.agnolin.sanitarios.dto.ProductDto;
import com.agnolin.sanitarios.model.Product;
import com.agnolin.sanitrarios.interfaces.IRepository;
import com.agnolin.sanitrarios.interfaces.IService;


public class ProductService implements IService<Product> {
	
	
	private IRepository<Product> productRepository;
	
	
	public void create(Product productDto){
		productRepository.create(productDto);
	}


	public void update(Product productDto) {
		productRepository.update(productDto);	
	}


	public IRepository<Product> getProductRepository() {
		return productRepository;
	}

	@Autowired
	public void setProductRepository(IRepository<Product> productRepository) {
		this.productRepository = productRepository;
		this.productRepository.setClazz(Product.class);
	}
		
}