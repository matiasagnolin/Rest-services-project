package com.agnolin.sanitarios.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDao< T extends Serializable > {
	

	private SessionFactory hibernateFactory;

	
	private Class<T> clazz;
	
	private final Session getCurrentSession() {
	      return hibernateFactory.getCurrentSession();
	   }
	public final void setClazz( Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
		@SuppressWarnings("unchecked")
		public T findOne( long id ){
	      return (T) getCurrentSession().get( clazz, id );
	   }
	   @SuppressWarnings("unchecked")
	public List< T > findAll(){
	      return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
	   }
	 
	   public void create( T entity ){
	      getCurrentSession().persist( entity );
	   }
	 
	   public void update( T entity ){
	      getCurrentSession().merge( entity );
	   }
	 
	   public void delete( T entity ){
	      getCurrentSession().delete( entity );
	   }
	   public void deleteById( long entityId ) {
	      T entity = findOne( entityId );
	      delete( entity );
	   }
	   
	   @Autowired
	   public void SomeService(EntityManagerFactory factory) {
	     if(factory.unwrap(SessionFactory.class) == null){
	       throw new NullPointerException("factory is not a hibernate factory");
	     }
	     this.hibernateFactory = factory.unwrap(SessionFactory.class);
	   }
}


