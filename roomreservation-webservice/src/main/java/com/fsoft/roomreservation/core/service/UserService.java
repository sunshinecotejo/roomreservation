package com.fsoft.roomreservation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fsoft.roomreservation.core.interfaces.IRepository;
import com.fsoft.roomreservation.core.model.ClientError;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.Reservation;
import com.fsoft.roomreservation.core.model.User;



@Service("userService")
public class UserService extends AbstractService<User> {
	@Autowired
    @Qualifier("userRepository")
    IRepository<User> repository;
	
	@Override
	protected IRepository<User> getRepository() {
		return repository;
	}
	
}
