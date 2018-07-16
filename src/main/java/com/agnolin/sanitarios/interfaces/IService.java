package com.agnolin.sanitarios.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IService<T extends Serializable> {
	
	public void create(T entity);
	
	public List<T> getAll();

	public void update(T entity);
}
