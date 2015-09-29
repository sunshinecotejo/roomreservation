package com.fsoft.roomreservation.webapp.model;

import java.io.Serializable;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Floor{
	
	private Integer floorId;


	private Integer floorNumber;
	
	private String floorName;
	
	private Building building;
	public Building getBuilding() {	return building; }
	public void setBuilding(Building building) { this.building = building; }
	
	
    private Set<Room> rooms;
	
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	public Integer getFloorId() {
		return floorId;
	}
	
	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	
}
