package com.agnolin.sanitarios.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreationDto {
	
	@NotNull
	private String name;
	
	@NotNull
	private double price;
	

	
}
