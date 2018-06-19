package com.iso.poreport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="im_employees")
@NamedNativeQueries({
@NamedNativeQuery(name="ImEmployees.findEmployeesByName", query="select * from users urs join im_employees emp"
		+ " on urs.user_id = emp.employee_id where emp.department_id = 62540 ",
resultClass=ImEmployees.class),
@NamedNativeQuery(name="ImEmployees.findEmployeesBySupervisor", query="select * from im_employees emp"
		+ " join users urs on urs.user_id = emp.employee_id where emp.department_id = 62540 and supervisor_id =:supervisorId ",
resultClass=ImEmployees.class)
})
public class ImEmployees {
	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	@Column(name="department_id")
	private Integer departmentId;
	@Column(name="job_title")
	private String jobTitle;
	@Column(name="job_description")
	private String jobDescription;
	@Column(name="availability")
	private Integer availability;
	@Column(name="supervisor_id")
	private Integer supervisorId;
	
	/*@OneToOne
	@JoinColumn(name = "employee_id")
	private Users user;*/
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	public Integer getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}	
	
	/*public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}*/
	public ImEmployees() {
		super();
	}
	
	

}
