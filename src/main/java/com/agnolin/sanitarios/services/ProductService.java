package com.agnolin.sanitarios.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.agnolin.sanitarios.dto.ProductDto;
import com.agnolin.sanitarios.interfaces.IRepository;
import com.agnolin.sanitarios.interfaces.IService;
import com.agnolin.sanitarios.model.Product;

@Component("ProductService")
@Service
public class ProductService implements IService<ProductDto> {
	
	
	private IRepository<Product> productRepository;
	
	
	public void create(ProductDto productDto){
		productRepository.create(productDto);
	}


	public void update(ProductDto productDto) {
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


	@Override
	public List<ProductDto> getAll() {
		List<Product> list = this.productRepository.findAll();
		return null;
	}

	

		
}
