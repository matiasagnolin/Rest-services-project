package com.agnolin.sanitarios.dto;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	   @Id
	    private Long id;

	private String name;
	
	
	private double price;


	public ProductDto() {
		super();
	}
	
	

}
