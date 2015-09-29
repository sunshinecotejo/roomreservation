package com.fsoft.roomreservation.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="room")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Room implements Serializable{
	
	private static final long serialVersionUID = 1988414884917499719L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name="roomid")
	private Integer roomId;
	
	@Column(name="roomname")
	private String roomName;
	
	@Column(name="roomcapacity")
	private Integer roomCapacity;
			
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "floorid")	
//	@JsonManagedReference
	private Floor floor;
	
	public Floor getFloor(){ return floor; }
	public Room setFloor( Floor floor ){ this.floor=floor; return this; }
	
	@OneToMany(mappedBy="room",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Reservation> reservations;
	
	public Set<Reservation> getReservations(){ return reservations; }
	public Room setReservations( Set<Reservation> reservations ){ this.reservations=reservations; return this; }
	
//	@OneToMany(mappedBy="room",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonBackReference
//    private List<RoomFacility> roomfacilities;
//	
//	public List<RoomFacility> getFacilities(){ return roomfacilities; }
//    public void setFacilities( List<RoomFacility> roomfacilities ){ this.roomfacilities=roomfacilities; }
    
	public Integer getRoomId() {
		return roomId;
	}
	public Room setRoomId(Integer roomId) {
		this.roomId = roomId;
		return this;
	}
	/*public Integer getFloorId() {
		return floorId;
	}
	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}*/
	public String getRoomName() {
		return roomName;
	}
	public Room setRoomName(String roomName) {
		this.roomName = roomName;
		return this;
	}
	public Integer getRoomCapacity() {
		return roomCapacity;
	}
	public Room setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
		return this;
	}
	
	
}
