package com.iso.poreport.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ResourceUtilization {
	private Integer uId;
	private String username;
	private int project_id;
	private BigDecimal sum;	
	private String path;
	private String project;
	private String sbu;
	private String system;
	private long absencesCount;
	private String absencesComment="";
	private String month;
	private String weekEndingDate;
	
	
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	
	@JsonIgnore
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getSbu() {
		return sbu;
	}
	public void setSbu(String sbu) {
		this.sbu = sbu;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}	
	@JsonIgnore
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public long getAbsencesCount() {
		return absencesCount;
	}
	public void setAbsencesCount(long absencesCount) {
		this.absencesCount = absencesCount;
	}
	
	
	public String getAbsencesComment() {
		return absencesComment;
	}
	public void setAbsencesComment(String absencesComment) {
		this.absencesComment = absencesComment;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getWeekEndingDate() {
		return weekEndingDate;
	}
	public void setWeekEndingDate(String weekEndingDate) {
		this.weekEndingDate = weekEndingDate;
	}
	public ResourceUtilization(Integer uId, String username, int project_id, BigDecimal sum, String path,
			String project, String sbu, String system, long absencesCount) {
		super();
		this.uId = uId;
		this.username = username;
		this.project_id = project_id;
		this.sum = sum;
		this.path = path;
		this.project = project;
		this.sbu = sbu;
		this.system = system;
		this.absencesCount = absencesCount;
	}
	public ResourceUtilization() {
		super();
	}	
	
	@Override
	public String toString() {
		return "ResourceUtilization [uId=" + uId + ", username=" + username + ", project_id=" + project_id + ", sum="
				+ sum + ", path=" + path + ", project=" + project + ", sbu=" + sbu + ", system=" + system
				+ ", absencesCount=" + absencesCount + ", absencesComment=" + absencesComment + "]";
	}
	private void arrangePath(String path) {
		String[] pathsColl = path.split("|"); 
 		if(pathsColl.length >= 4) {
			
		}
	}
	
	
}
