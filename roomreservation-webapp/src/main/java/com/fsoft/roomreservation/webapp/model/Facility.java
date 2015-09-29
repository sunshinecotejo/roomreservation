package com.fsoft.roomreservation.webapp.model;

import java.io.Serializable;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonBackReference;

public class Facility  {
	
	
	
	
	private Integer facilityId;
	
	
	private String facilityName;
	
	private String serial;
	
	private String description;


    private Set<RoomFacility> roomfacilities;
	
	public Set<RoomFacility> getRoomfacilities() {
		return roomfacilities;
	}

	public void setRoomfacilities(Set<RoomFacility> roomfacilities) {
		this.roomfacilities = roomfacilities;
	}

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
