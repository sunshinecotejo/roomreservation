package com.fsoft.roomreservation.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.Floor;

@RestController
@RequestMapping(value="/floor")
public class FloorManagementController extends AbstractController{
	@Autowired
	@Qualifier("floorService")
	private IService<Floor> service;
	
	@Override
	public IService getService() {
		return service;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ClientResponseEntity<List<Floor>> getList(){
		return super.getList();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/read/{id}", method=RequestMethod.GET)
	public ClientResponseEntity<Floor> read(@PathVariable("id") Integer id){
		return super.read(id);
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ClientResponseEntity<Floor> create(@RequestBody Floor floor){
		return super.create(floor);
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ClientResponseEntity<Floor> update(@RequestBody Floor floor){
		return super.update(floor);
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ClientResponseEntity<Boolean> delete(@PathVariable("id") Integer id){
		return super.delete(id);
	}
	
}
