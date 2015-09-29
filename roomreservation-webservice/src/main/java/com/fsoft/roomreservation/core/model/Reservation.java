package com.fsoft.roomreservation.core.model;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name="reservation")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Reservation implements Serializable{
	
	private static final long serialVersionUID = -8500886812557091632L;

	@Id
	@GeneratedValue
	@Column(name="reservationid")
	private Integer reservationid;
	
	@Column(name="userid")
	private Integer userId;
	
	@Column(name="roomid")
	private Integer roomId;
	
	@Column(name="reservationschedule")
	private Date reservationSchedule;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	public String getTitle() {
		return title;
	}
	
	public Reservation setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	public Reservation setDescription(String description) {
		this.description = description;
		return this;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="roomid", insertable = false, updatable = false)
	private Room room;
	
	public Room getRoom(){ return room; }
	public Reservation setRoom( Room room ){ this.room=room; return this; }
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	private User user;
	
	public User getUser(){ return user; }
	public Reservation setUser( User user ){ this.user=user; return this; }
	
	public Integer getReservationid() {
		return reservationid;
	}

	public Reservation setReservationid(Integer reservationid) {
		this.reservationid = reservationid;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public Reservation setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public Reservation setRoomId(Integer roomId) {
		this.roomId = roomId;
		return this;
	}

	public Date getReservationSchedule() {
		return reservationSchedule;
	}

	public Reservation setReservationSchedule(Date reservationSchedule) {
		this.reservationSchedule = reservationSchedule;
		return this;
	}

	public int getDuration() {
		return duration;
	}

	public Reservation setDuration(int duration) {
		this.duration = duration;
		return this;
	}
	
}
