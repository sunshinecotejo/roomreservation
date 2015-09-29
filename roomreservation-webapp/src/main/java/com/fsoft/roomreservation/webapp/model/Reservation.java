package com.fsoft.roomreservation.webapp.model;

import java.util.Date;


public class Reservation {
	

	private Integer reservationid;
	

	private Integer userId;
	

	private Integer roomId;
	

	private Date reservationSchedule;
	

	private Integer duration;
	
	private String title;
	
	private String description;
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Room room;
	
	public Room getRoom(){ return room; }
	
	public void setRoom( Room room ){ this.room=room; }
	
	private User user;
	public User getUser(){ return user; }
	public void setUser( User user ){ this.user=user; }
	
	
	public Integer getReservationid() {
		return reservationid;
	}

	public void setReservationid(Integer reservationid) {
		this.reservationid = reservationid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Date getReservationSchedule() {
		return reservationSchedule;
	}

	public void setReservationSchedule(Date reservationSchedule) {
		this.reservationSchedule = reservationSchedule;
	}
	
	
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
}
