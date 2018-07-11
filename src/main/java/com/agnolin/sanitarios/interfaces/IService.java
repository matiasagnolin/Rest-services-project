package com.agnolin.sanitarios.interfaces;

import java.io.Serializable;

public interface IService<T extends Serializable> {
	
	public void create(T entity);


	public void update(T entity);
}
