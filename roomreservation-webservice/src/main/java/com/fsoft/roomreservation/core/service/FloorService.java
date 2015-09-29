package com.fsoft.roomreservation.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fsoft.roomreservation.core.interfaces.IRepository;
import com.fsoft.roomreservation.core.model.ClientError;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.Floor;

@Service("floorService")
public class FloorService extends AbstractService<Floor>{
	@Autowired
    @Qualifier("floorRepository")
    IRepository<Floor> repository;

	@Override
	protected IRepository<Floor> getRepository() {
		return repository;
	}
	
	@Override
	public List<Floor> getList(){
		try{
			return super.getList();
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return new ArrayList<Floor>();
	}
	
	@Override
	public Floor read(Integer id){
		try{
			return super.read(id);
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return new Floor();
	}
	
	@Override
	public Floor create( Floor floor ){
		try{
			return super.create(floor);
		}catch( Exception ex ){
		}
		
		return new Floor();
	}
	
	@Override
	public Floor update( Floor floor ){
		try{
			return super.update(floor);
		}catch( Exception ex ){
		}
		
		return new Floor();
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
