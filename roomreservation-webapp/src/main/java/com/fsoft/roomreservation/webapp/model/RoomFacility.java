package com.fsoft.roomreservation.webapp.model;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


public class RoomFacility implements Serializable{

	private Integer room_facilityId;
	
	private Integer roomid;
	public Integer getRoomId(){ return roomid; }
	public void setRoomId( Integer roomid ){ this.roomid=roomid; }
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "roomId")	
//	@JsonIgnore
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name = "roomid", insertable = false, updatable = false)
//	@JsonIgnore
//	private Room room;
	
	
	private Facility facility;
	
	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	private Integer quantity;

	public Integer getRoom_facilityId() {
		return room_facilityId;
	}


	public void setRoom_facilityId(Integer room_facilityId) {
		this.room_facilityId = room_facilityId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


//	public Room getRoom() {
//		return room;
//	}
//
//
//	public void setRoom(Room room) {
//		this.room = room;
//	}
	
}
