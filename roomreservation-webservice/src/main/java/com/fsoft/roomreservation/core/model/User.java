package com.fsoft.roomreservation.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable{
	
	private static final long serialVersionUID = -2062977284543698085L;

	@Id
	@GeneratedValue
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="password")	
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name="user_role", 
                joinColumns={@JoinColumn(name="userID")}, 
                inverseJoinColumns={@JoinColumn(name="roleID")})
	private Set<Role> roles = new HashSet<Role>();
	
//	@OneToMany(mappedBy="user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonBackReference
//	private Set<UserRole> userRoles;
//	
//	public Set<UserRole> getUserRoles(){ return this.userRoles; }
//	public void setUserRoles( Set<UserRole> userRoles){ this.userRoles=userRoles; }
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Reservation> reservations;
	
	public Set<Reservation> getReservations(){ return reservations; }
	public User setReservations( Set<Reservation> reservations ){ this.reservations=reservations; return this; }
	
	public Integer getUserid() {
		return userid;
	}

	public User setUserid(Integer userid) {
		this.userid = userid;
		return this;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public User setRoles(Set<Role> roles) {
		this.roles = roles;
		return this;
	}

	
	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	
}
