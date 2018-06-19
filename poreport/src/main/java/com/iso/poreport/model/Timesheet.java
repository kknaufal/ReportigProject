package com.iso.poreport.model;

import java.math.BigDecimal;

public class Timesheet {
	
	private String userName;
	private Integer projectId;
	private Integer employeeId;
	private String tfs;
	private String client;
	private String description;
	private BigDecimal effort;
	private String dateRange;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTfs() {
		return tfs;
	}
	public void setTfs(String tfs) {
		this.tfs = tfs;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getEffort() {
		return effort;
	}
	public void setEffort(BigDecimal effort) {
		this.effort = effort;
	}
	public String getDateRange() {
		return dateRange;
	}
	public void setDateRange(String dtRange) {
		this.dateRange = dtRange;
	}	
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Timesheet() {
		super();
	}
	@Override
	public String toString() {
		return "Timesheet [userName=" + userName + ", projectId=" + projectId + ", employee_id=" + employeeId
				+ ", tfs=" + tfs + ", client=" + client + ", description=" + description + ", effort=" + effort
				+ ", dtRange=" + dateRange + "]";
	}	
	

}
