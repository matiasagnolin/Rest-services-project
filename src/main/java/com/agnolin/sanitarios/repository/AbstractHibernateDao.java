package com.agnolin.sanitarios.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractHibernateDao< T extends Serializable > {
	
	
	 @PersistenceContext
	 EntityManager em;
	 
	 public EntityManager getEm() {
			return em;
		}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	private Class<T> clazz;
	
	private final Session getCurrentSession() {
	      //return hibernateFactory.getCurrentSession();
		return em.unwrap(SessionFactory.class).getCurrentSession();
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
	 
	   @Transactional
	   public void create( T entity ){
	     // getCurrentSession().persist( entity );
		   em.persist(entity);
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
	   
//	   @Autowired
//	   public void setSessionFactory(EntityManagerFactory factory) {
//	     if(factory.unwrap(SessionFactory.class) == null){
//	       throw new NullPointerException("factory is not a hibernate factory");
//	     }
//	     this.hibernateFactory = factory.unwrap(SessionFactory.class);
//	   }
}


