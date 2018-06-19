package com.iso.poreport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@Entity
@Table(name="im_projects")
@NamedNativeQuery(name="ImProjects.findParentProjectsByName", query="select * from im_projects where parent_id is NULL "
		+ "and im_projects.project_lead_id in (select employee_id from im_employees where department_id=62540)",
resultClass = ImProjects.class)		
//+"And project_name ILIKE CONCAT('%',:projectName,'%') ", resultClass = ImProjects.class)
public class ImProjects {
	@Id
	@GeneratedValue
	@Column(name="project_id")
	private Integer projectId ;
	@Column(name="project_name")
	private String projectName;
	@Column(name="project_nr")
	private String projectNr;
	@Column(name="project_path")
	private String projectPath;
	@Column(name="parent_id")
	private Integer parentId;
	@Column(name="project_type_id")
	private Integer projectTypeId;
	@Column(name="project_status_id")
	private Integer projectStatusId;
	@Column(name="description")
	private String description;
	@Column(name="billing_type_id")
	private Integer billingTypeId;
	@Column(name="note")
	private String note;
	@Column(name="project_lead_id")
	private Integer projectLeadId;
	@Column(name="supervisor_id")
	private Integer supervisorId;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectNr() {
		return projectNr;
	}
	public void setProjectNr(String projectNr) {
		this.projectNr = projectNr;
	}
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	public Integer getProjectStatusId() {
		return projectStatusId;
	}
	public void setProjectStatusId(Integer projectStatusId) {
		this.projectStatusId = projectStatusId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getBillingTypeId() {
		return billingTypeId;
	}
	public void setBillingTypeId(Integer billingTypeId) {
		this.billingTypeId = billingTypeId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getProjectLeadId() {
		return projectLeadId;
	}
	public void setProjectLeadId(Integer projectLeadId) {
		this.projectLeadId = projectLeadId;
	}
	public Integer getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}
	
	public ImProjects() {
		super();
	}
	public ImProjects(Integer projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	}
}
