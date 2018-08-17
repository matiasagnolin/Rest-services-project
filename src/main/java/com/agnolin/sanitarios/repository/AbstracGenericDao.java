package com.agnolin.sanitarios.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class AbstracGenericDao <T extends Serializable>{
	
 protected Class<T> clazz;
	 
	 @PersistenceContext
	 EntityManager em;
	 
		
		public  Class<T> getClazz(){
		      return clazz;
		   }
		

		
		public void setClazz(Class<T> clazz) {
			this.clazz = clazz;
			
		}

		 
		 
		 private int count=0;
		 
		 public EntityManager getEm() {
				return em;
			}
		
		public void setEm(EntityManager em) {
			this.em = em;
		}

			@Transactional
			public T findOne(  long id ){
				return em.find(clazz, id);
		   }
			@Transactional
		   public List< T > findAll(){
			   return em.createQuery( "Select a From "+clazz.getSimpleName()+" a", clazz ).getResultList();
		   }
		 
		   @Transactional
		   public void create( T entity ){
			   em.persist(entity);
		   }
		 
		   @Transactional
		   public void update( T entity ){
		      em.merge(entity);
		   }
		 
		   @Transactional
		   public void delete( T entity ){
		      em.remove(entity);
		      
		   }
		   @Transactional
		   public void deleteById( long entityId ) {
		      T entity = findOne( entityId );
		      delete( entity );
		   }
		   
		   public void count() {
			   count++;
		   }
	
	
}
