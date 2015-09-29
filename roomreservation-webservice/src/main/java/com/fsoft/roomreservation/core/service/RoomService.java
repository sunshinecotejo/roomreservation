package com.fsoft.roomreservation.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.roomreservation.core.interfaces.IRepository;
import com.fsoft.roomreservation.core.model.Room;

@Service("roomService")
@Transactional
public class RoomService extends AbstractService<Room>{
	@Autowired
    @Qualifier("roomRepository")
    IRepository<Room> repository;

	@Override
	protected IRepository<Room> getRepository() {
		return repository;
	}
	
	@Override
	public List<Room> getList(){
		try{
			return super.getList();
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return new ArrayList<Room>();
	}
	
	@Override
	
	public Room read(Integer id){
		try{
			return super.read(id);
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return new Room();
	}
	
	@Override
	public Room create( Room room ){
		try{
			return super.create(room);
		}catch( Exception ex ){
		}
		
		return new Room();
	}
	
	@Override
	public Room update( Room room ){
		try{
			return super.update(room);
		}catch( Exception ex ){
		}
		
		return new Room();
	}
	
	@Override
	public Boolean delete( Integer id ){
		try{
			super.delete(id);
		}catch( Exception ex ){
			return new Boolean( false ); 
		}
		
		return new Boolean( true );
	}
}