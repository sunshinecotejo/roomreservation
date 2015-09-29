package com.fsoft.roomreservation.core.repository;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.roomreservation.core.model.User;


@Repository("userRepository")
@Transactional
public class UserRepository extends AbstractRepository<User>{

	@Override
	protected Class<?> getPersistentClass() {
		return User.class;
	}
	
	@Override
	 public User read( Integer userID ){
		Session session = sessionFactory.openSession();
		User type = (User) session.createCriteria(getPersistentClass())  
                .add(Restrictions.idEq(userID))  
                .uniqueResult(); 
		Hibernate.initialize(type.getRoles());
    	return type;
	 }
	
	@Override
	public User readField(String field, Object value) {
		return super.readField(field, value);
	}
}
