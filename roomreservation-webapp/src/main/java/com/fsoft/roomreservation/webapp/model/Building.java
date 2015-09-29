package com.fsoft.roomreservation.webapp.model;




public class Building  {
	
	private Integer buildingId;
	private String buildingName;
	private String buildingAddress;


	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingAddress() {
		return buildingAddress;
	}

	public void setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
	}

}
