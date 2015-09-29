package com.fsoft.roomreservation.webapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



public class Role implements Serializable{
	

	private Integer roleId;
	
	
	private String roleName;		
	
    private Set<User> users = new HashSet<User>();
    
	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
