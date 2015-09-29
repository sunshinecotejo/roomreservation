package com.fsoft.roomreservation.core.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.roomreservation.core.model.Room;


@Repository("roomRepository")
public class RoomRepository extends AbstractRepository<Room> {

	@Override
	protected Class<?> getPersistentClass() {
		return Room.class;
	}
	
	@Transactional
	@Override
	public List<Room> getList(){
		Session session = null;
		List<Room> list ;
		
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(getPersistentClass())
									   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list =criteria.list(); 
			for(Room room: list){
				Hibernate.initialize(room.getFloor());
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
        return list;
	}
	
	
	@Transactional
	@Override
	 public Room read( Integer roomId ){
		Session session = null;
		Room type;
		
		try{
			session = sessionFactory.openSession();
			type= (Room) session.createCriteria(getPersistentClass())  
	                .add(Restrictions.idEq(roomId))  
	                .uniqueResult(); 
			Hibernate.initialize(type.getFloor());
		}finally{
			session.close();
		}
    	return type;
	 }

	 @Override
	 public Room create( Room room ) throws Exception{
		 return super.create(room);
	 }

	 @Override
	 public Room update( Room room) throws Exception{
		 return super.update(room );
	 }

	 @Override
	 public void delete( Integer roomId ) throws Exception{
		 super.delete( roomId);
	 	}
	 }

