package com.iso.poreport.model;

import java.math.BigDecimal;

public class ResourceHours {
	String userName;
	BigDecimal totalHours;
	Integer userId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(BigDecimal totalHours) {
		this.totalHours = totalHours;
	}	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public ResourceHours(String userName, BigDecimal totalHours) {
		super();
		this.userName = userName;
		this.totalHours = totalHours;
	}

	public ResourceHours() {
		super();
	}

	@Override
	public String toString() {
		return "ResourceHours [userName=" + userName + ", totalHours=" + totalHours + "]";
	}

}
