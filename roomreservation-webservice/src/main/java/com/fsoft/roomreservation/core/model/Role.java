package com.fsoft.roomreservation.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="role")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Role implements Serializable{
	
	private static final long serialVersionUID = 6728914418694137553L;

	@Id
	@GeneratedValue
	@Column(name="roleID")	
	private Integer roleId;
	
	@Column(name="roleName", updatable=false)
	private String roleName;		
	
	@ManyToMany(mappedBy="roles")
    private Set<User> users = new HashSet<User>();
    
	public Integer getRoleId() {
		return roleId;
	}

	public Role setRoleId(Integer roleId) {
		this.roleId = roleId;
		return this;
	}

	public String getRoleName() {
		return roleName;
	}

	public Role setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
}
