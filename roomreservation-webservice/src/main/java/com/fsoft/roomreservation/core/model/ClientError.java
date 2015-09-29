package com.fsoft.roomreservation.core.model;

import java.io.Serializable;

public class ClientError implements Serializable{
	
	private static final long serialVersionUID = -384544873815088888L;
	
	private int code;
	private String message;
	
	public boolean isEmpty(){
		return (0 == this.code && null == this.message);
	}
	
	public int getCode() {
		return code;
	}
	
	public ClientError setCode(int code) {
		this.code = code;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public ClientError setMessage(String message) {
		this.message = message;
		return this;
	}
}
