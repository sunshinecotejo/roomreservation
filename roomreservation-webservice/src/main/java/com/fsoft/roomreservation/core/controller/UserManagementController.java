package com.fsoft.roomreservation.core.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.roomreservation.core.interfaces.IService;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.User;



@RestController
@RequestMapping(value="/user")
public class UserManagementController extends AbstractController{

	@Autowired
	@Qualifier("userService")
	private IService<User> service;
	
	@Override
	public IService getService() { return service; }
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ClientResponseEntity<User> addUser(@RequestBody User user){	
		return super.create(user);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/read/{id}",method=RequestMethod.GET)
	public ClientResponseEntity<User> read(@PathVariable("id") Integer id){				
		return super.read(id);	
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getUser/{email}",method=RequestMethod.GET)
	public User getUserFromField(@PathVariable("email") String email){		
		return service.readField("email",email);		
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ClientResponseEntity<Boolean> delete(@PathVariable("id") Integer id){				
		return super.delete(id);		
	}
	
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ClientResponseEntity<User> update(@RequestBody User user){								
		return super.update(user); 
	}
	
}
