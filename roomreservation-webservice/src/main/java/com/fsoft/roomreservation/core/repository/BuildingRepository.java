package com.fsoft.roomreservation.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.roomreservation.core.model.Building;


@Repository("buildingRepository")
@Transactional
public class  BuildingRepository extends AbstractRepository<Building> {

	@Override
	protected Class<?> getPersistentClass() {
		return Building.class;
	}
	
	@Override
	public List<Building> getList(){
		return super.getList();
	}
	
	@Override
	 public Building read( Integer buildingId ){
		 return super.read(buildingId);
	 }

	 @Override
	 public Building create( Building building ) throws Exception{
		 return super.create(building);
	 }

	 @Override
	 public Building update( Building building ) throws Exception{
		 return super.update( building );
	 }

	 @Override
	 public void delete( Integer buildingId ) throws Exception{
		 super.delete( buildingId);
	 }

}
