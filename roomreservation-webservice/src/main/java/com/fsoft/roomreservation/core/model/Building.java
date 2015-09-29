package com.fsoft.roomreservation.core.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "building")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Building implements Serializable {
	private static final long serialVersionUID = 7467533651915825750L;

	@Id
	@GeneratedValue
	@Column(name = "buildingid")
	private Integer buildingId;

	@Column(name = "buildingname")
	private String buildingName;

	@Column(name = "buildingaddress")
	private String buildingAddress;

	@OneToMany(mappedBy = "building")
	@JsonBackReference
	private Set<Floor> floors = new HashSet<Floor>();

	public Integer getBuildingId() {
		return buildingId;
	}

	public Building setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
		return this;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public Building setBuildingName(String buildingName) {
		this.buildingName = buildingName;
		return this;
	}

	public String getBuildingAddress() {
		return buildingAddress;
	}

	public Building setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
		return this;
	}

}
