package com.fsoft.roomreservation.webapp.model;

import java.util.HashSet;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class User {
	
	private Integer userid;
		
	private String password;
	
	private String email;

	private Set<Role> roles = new HashSet<Role>();
				
	private Set<Reservation> reservations;
	
	private String firstName;
	private String lastName;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Reservation> getReservations(){ return reservations; }
	public void setReservations( Set<Reservation> reservations ){ this.reservations=reservations; }
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
