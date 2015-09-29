package com.fsoft.roomreservation.core.model;

import java.io.Serializable;

public class ClientResponseEntity<T> implements Serializable{

	private static final long serialVersionUID = 485490446400147226L;

	private int code;
	private String message;
	
	private T t;
	
	public int getCode() {
		return code;
	}
	
	public ClientResponseEntity<T> setCode(int code) {
		this.code = code;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public ClientResponseEntity<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public T getEntity() {
		return t;
	}
	
	public ClientResponseEntity<T> setEntity(T t) {
		this.t = t;
		return this;
	}
}
