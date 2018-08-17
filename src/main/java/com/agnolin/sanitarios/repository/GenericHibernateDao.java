package com.agnolin.sanitarios.repository;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.config.BeanDefinition;


import com.agnolin.sanitarios.interfaces.IRepository;

@Repository
@Scope(value=BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao<T extends Serializable> extends AbstracGenericDao<T> implements IRepository<T> {

	

	@Override
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
		
	}




}
