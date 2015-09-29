package com.fsoft.roomreservation.core.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.roomreservation.core.interfaces.IRepository;
import com.fsoft.roomreservation.core.util.CommonUtil;

public abstract class AbstractRepository<T> implements IRepository<T>{
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected abstract Class<?> getPersistentClass();
	
	protected SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
    public List<T> getList() {
		Session session = null;
		List<T> list = null;
		try{
			session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(getPersistentClass())
									   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criteria.setCacheable(true).list();
		}finally{
			CommonUtil.closeQuitely(session);
		}
		return list;
    }
	
	@Transactional
	public T create( T type ) throws Exception{
		Session session =null;
		try{
			session= getSessionFactory().openSession();		
			session.getTransaction().begin();
			session.save( type );
			session.getTransaction().commit();
			session.flush();		
		}finally{
			CommonUtil.closeQuitely(session);
		}
		return type;
	}
    
	@Transactional
    public T update( T type ) throws Exception{
		Session session=null;
		try{
			session= getSessionFactory().openSession();
			session.getTransaction().begin();
			session.update(type);
			session.getTransaction().commit();
			session.flush();		
		}finally{
			CommonUtil.closeQuitely(session);
		}
    	return type;
    }
    
	@Transactional
	@SuppressWarnings("unchecked")
    public void delete( Integer id ) throws Exception{		
		Session session = null;
		try{
			session = getSessionFactory().openSession();
			session.getTransaction().begin();
			T type = (T) session.load(getPersistentClass(), id);
		    session.delete(type);
		    session.getTransaction().commit();
		    session.flush();
		}finally{
			CommonUtil.closeQuitely(session);
		}
    }
    
	@SuppressWarnings("unchecked")
	@Transactional
    public T read( Integer id ){
		Session session = null;
		try{
			session = getSessionFactory().openSession();				
			return (T) session.createCriteria(getPersistentClass())  
							.add(Restrictions.idEq(id))
			                .setCacheable(true)  
			                .uniqueResult();
		}finally{
			CommonUtil.closeQuitely(session);
		}
    }
    
	@SuppressWarnings("unchecked")
	@Transactional
    public T readField(String field,Object value){
		Session session = null;
		try{
			session = getSessionFactory().openSession();
			return (T) session.createCriteria(getPersistentClass())  
			                  .add(Restrictions.eq(field, value))  
			                  .setCacheable(true)
				              .uniqueResult();
		}finally{
			CommonUtil.closeQuitely(session);
		}
    }
	
}
