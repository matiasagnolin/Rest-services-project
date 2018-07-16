package com.agnolin.sanitarios.interfaces;

import java.io.Serializable;
import java.util.List;


public interface IRepository<T extends Serializable> {
	
   public T findOne( final long id );
		
   public List< T > findAll();

   public void create( final T entity );
   
   public void update(final T entity );

   public void delete(final T entity );

   public void deleteById(final long entityId );

   public void setClazz(Class<T> clazz);
   
   

	
}
