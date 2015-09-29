package com.fsoft.roomreservation.core.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.roomreservation.core.model.RoomFacility;


@Repository("roomFacilityRepository")
@Transactional
public class RoomFacilityRepository extends AbstractRepository<RoomFacility>{

	@Override
	protected Class<?> getPersistentClass() {
		return RoomFacility.class;
	}

}
