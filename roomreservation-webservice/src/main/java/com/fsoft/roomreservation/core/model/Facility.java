package com.fsoft.roomreservation.core.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="facility")
public class Facility  implements Serializable{
	
	
	private static final long serialVersionUID = 1988452128596421719L;
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="facilityId")	
	private Integer facilityId;
	
	
	@Column(name="facilityName")
	private String facilityName;
	
	@Column(name="serial")
	private String serial;
	
	@Column(name="description")
	private String description;


	@OneToMany(mappedBy="facility", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
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
