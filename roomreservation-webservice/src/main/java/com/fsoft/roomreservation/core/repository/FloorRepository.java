package com.fsoft.roomreservation.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.roomreservation.core.model.Floor;

@Repository("floorRepository")
@Transactional
public class FloorRepository extends AbstractRepository<Floor> {

	@Override
	protected Class<?> getPersistentClass() {
		return Floor.class;
	}
	
	@Override
	public List<Floor> getList(){		
		return super.getList();
	}
	
	@Override
	 public Floor read( Integer floorId ){
		 return super.read(floorId);
	 }

	 @Override
	 public Floor create( Floor floor ) throws Exception{
		 return super.create(floor);
	 }

	 @Override
	 public Floor update( Floor floor) throws Exception{
		 return super.update(floor );
	 }

	 @Override
	 public void delete( Integer floorId ) throws Exception{
		 super.delete( floorId);
	 }

}
