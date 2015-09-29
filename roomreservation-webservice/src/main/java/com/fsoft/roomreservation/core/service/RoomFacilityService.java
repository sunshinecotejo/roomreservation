package com.fsoft.roomreservation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fsoft.roomreservation.core.interfaces.IRepository;
import com.fsoft.roomreservation.core.model.ClientError;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.Reservation;
import com.fsoft.roomreservation.core.model.RoomFacility;



@Service("roomFacilityService")
public class RoomFacilityService extends AbstractService<RoomFacility> {
	@Autowired
    @Qualifier("roomFacilityRepository")
    IRepository<RoomFacility> repository;
	
	@Override
	protected IRepository<RoomFacility> getRepository() {
		return repository;
	}
	
}
