package com.fsoft.roomreservation.core.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Table(name="floor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Floor implements Serializable{
	
	private static final long serialVersionUID = -5876461227990661747L;

	@Id
	@GeneratedValue
	@Column(name="floorid")
	private Integer floorId;


	@Column(name="floornumber")
	private Integer floorNumber;
	
	@Column(name="floorname")
	private String floorName;
	
	@JoinColumn(name="buildingid", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Building building;
	public Building getBuilding() {	return building; }
	public void setBuilding(Building building) { this.building = building; }
	
	
	@OneToMany(mappedBy="floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
    private Set<Room> rooms;
	
	public Set<Room> getRooms() {
		return rooms;
	}
	public Floor setRooms(Set<Room> rooms) {
		this.rooms = rooms;
		return this;
	}
	public Integer getFloorId() {
		return floorId;
	}
	
	public Floor setFloorId(Integer floorId) {
		this.floorId = floorId;
		return this;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public Floor setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
		return this;
	}

	public String getFloorName() {
		return floorName;
	}

	public Floor setFloorName(String floorName) {
		this.floorName = floorName;
		return this;
	}
	
}
