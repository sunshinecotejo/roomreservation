package com.fsoft.roomreservation.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fsoft.roomreservation.core.interfaces.IRepository;
import com.fsoft.roomreservation.core.model.Building;
import com.fsoft.roomreservation.core.model.ClientError;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.Reservation;


@Service("buildingService")
public class BuildingService extends AbstractService<Building>{
	@Autowired
    @Qualifier("buildingRepository")
    IRepository<Building> repository;

	@Override
	protected IRepository<Building> getRepository() {
		return repository;
	}
	
	@Override
	public List<Building> getList(){
		try{
			return super.getList();
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return new ArrayList<Building>();
	}
	
	@Override
	public Building read(Integer id){
		try{
			return super.read(id);
		}catch( Exception ex ){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return new Building();
	}
	
	@Override
	public Building create( Building building ){
		try{
			return super.create(building);
		}catch( Exception ex ){
		}
		
		return new Building();
	}
	
	@Override
	public Building update( Building building ){
		try{
			return super.update(building);
		}catch( Exception ex ){
		}
		
		return new Building();
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
