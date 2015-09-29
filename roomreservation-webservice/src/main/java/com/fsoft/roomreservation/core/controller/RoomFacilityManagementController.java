package com.fsoft.roomreservation.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.RoomFacility;




@RestController
@RequestMapping(value="/roomFacility")
public class RoomFacilityManagementController extends AbstractController{

	@Autowired
	@Qualifier("roomFacilityService")
	private IService<RoomFacility> service;
	
	@Override
	public IService getService() {
		return service;
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ClientResponseEntity<RoomFacility> createRoomFacility(@RequestBody RoomFacility roomFacility){								
		return super.create(roomFacility); 
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ClientResponseEntity<RoomFacility> updateRoomFacility(@RequestBody RoomFacility roomFacility){								
		return super.create(roomFacility); 
	}
	
	
	@Secured("ROLE_ADMIN")
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/read/{id}",method=RequestMethod.GET)
	public ClientResponseEntity<RoomFacility> readRoomFacility(@PathVariable("id") Integer id){				
		return super.read(id);		
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ClientResponseEntity<RoomFacility> deleteRoomFacility(@PathVariable("id") Integer id){				
		return super.delete(id);		
	}

}
