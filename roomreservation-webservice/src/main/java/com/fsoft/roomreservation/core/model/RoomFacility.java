package com.fsoft.roomreservation.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="room_facility")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="room_facilityId")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class RoomFacility implements Serializable{

	private static final long serialVersionUID = 3803764072006032742L;

	@Id
	@GeneratedValue
	@Column(name="room_facilityId")
	private Integer room_facilityId;
	
	@Column(name="roomid")
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "facilityId")
	@JsonManagedReference
	private Facility facility;
	
	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	@Column(name="quantity")
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
