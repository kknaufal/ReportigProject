package com.iso.poreport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
		@NamedQuery(name = "Users.findUserByName",
				query = "select new Users(usr.userId, usr.username) from Users usr join usr.imEmployee emp"
				+ "  where emp.departmentId = 62540 "),
		@NamedQuery(name = "Users.findUsersBySupervisor", 
		query = "select new Users(usr.userId, usr.username) from Users usr join usr.imEmployee emp"
				+ " where emp.departmentId = 62540 and emp.supervisorId =:supervisorId ") })
public class Users {
	@Id
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "authority_id")
	private Integer authorityId;
	@Column(name = "username")
	private String username;
	@Column(name = "screen_name")
	private String screenName;
	@Column(name = "priv_name")
	private Integer privName;

	@OneToOne
	@JoinColumn(name = "user_id")
	private ImEmployees imEmployee;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Integer getPrivName() {
		return privName;
	}

	public void setPrivName(Integer privName) {
		this.privName = privName;
	}

	public ImEmployees getImEmployee() {
		return imEmployee;
	}

	public void setImEmployee(ImEmployees imEmployee) {
		this.imEmployee = imEmployee;
	}

	public Users() {
		super();
	}

	public Users(Integer userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

}
