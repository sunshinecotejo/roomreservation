package com.fsoft.roomreservation.core.controller;

import java.util.List;

//import net.sf.ehcache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.Reservation;


@Controller
@RequestMapping("/reservationmgt")
public class ReservationManagementController extends AbstractController{
	
	@Autowired
	@Qualifier("reservationService")
	private IService<Reservation> service;
	
	@Override
	public IService getService() {
		return service;
	}
	
	public ReservationManagementController() {}
	public ReservationManagementController( IService service ) {
		this.service = service; 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", method=RequestMethod.GET)
	@ResponseBody
	public ClientResponseEntity<List<Reservation>> getList(){
		return super.getList();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/create", method=RequestMethod.POST) 
	@ResponseBody
	public ClientResponseEntity<Reservation> create(@RequestBody Reservation reservation){
		return super.create(reservation);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/read/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ClientResponseEntity<Reservation> read(@PathVariable("id") Integer id){
		return super.read(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseBody
	public ClientResponseEntity<Reservation> update(@RequestBody Reservation reservation){
		return super.update(reservation);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public ClientResponseEntity<Boolean> delete(@PathVariable("id") Integer id){
		return super.delete(id);
	}

}
