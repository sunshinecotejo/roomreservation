package com.fsoft.roomreservation.core.controller;

import java.util.List;

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
import com.fsoft.roomreservation.core.model.Room;

@RestController
@RequestMapping(value="room")
public class RoomManagementController extends AbstractController{
	@Autowired
	@Qualifier("roomService")
	private IService<Room> service;
	
	@Override
	public IService getService() {
		return service;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ClientResponseEntity<List<Room>> getList(){
		return super.getList();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/read/{id}",method=RequestMethod.GET)
	public ClientResponseEntity<Room> read(@PathVariable("id") Integer id){
		return super.read(id);
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ClientResponseEntity<Room> create(@RequestBody Room room){
		return super.create(room);
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ClientResponseEntity<Room> update(@RequestBody Room room){
		return super.update(room);
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ClientResponseEntity<Room> delete(@PathVariable("id") Integer id){
		return super.delete(id);
	}
}
