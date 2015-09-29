package com.fsoft.roomreservation.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fsoft.roomreservation.core.interfaces.IRepository;
import com.fsoft.roomreservation.core.model.ClientError;
import com.fsoft.roomreservation.core.model.ClientResponseEntity;
import com.fsoft.roomreservation.core.model.Reservation;
import com.fsoft.roomreservation.core.service.email.EmailService;

@Service("reservationService")
public class ReservationService extends AbstractService<Reservation>{
	
	@Autowired
    @Qualifier("reservationRepository")
    IRepository<Reservation> repository;
	
	@Override
	protected IRepository<Reservation> getRepository() {
		return repository;
	}
	
	@Override
	public List<Reservation> getList(){
		try{
			return super.getList();
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return new ArrayList<Reservation>();
	}
	
	@Override
	public Reservation create( Reservation reservation ){
		try{
			synchronized (reservation.getReservationSchedule()) {
				return super.create(reservation);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return reservation;
	}
	
	@Override
	public Reservation read( Integer id ) {
		try{
			return super.read(id);
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return new Reservation();
	}
	
	@Override
	public Reservation update( Reservation reservation ){
		try{
			return super.update(reservation);
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		return reservation;
	}
	
	@Override
	public Boolean delete( Integer id ){
		try{
			super.delete(id);
			return new Boolean( true ); 
		}catch( Exception ex ){
			throw new IllegalStateException(ex.getMessage(),ex);
		}
	}
}
