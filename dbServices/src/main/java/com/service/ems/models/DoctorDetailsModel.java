package com.service.ems.models;

import java.util.List;

import com.service.ems.constants.Gender;

public class DoctorDetailsModel {
	
	private Long id;
	private Gender gender;
	private String experiance;
	private String qualification;
	private double consultationFee;
	private List<ScheduleModel> scheduleList;
	/**
	 * 
	 */
	public DoctorDetailsModel() {
		super();
	}
	/**
	 * @param id
	 * @param gender
	 * @param experiance
	 * @param qualification
	 * @param consultationFee
	 * @param scheduleList
	 */
	public DoctorDetailsModel(long id, Gender gender, String experiance, String qualification, double consultationFee,
			List<ScheduleModel> scheduleList) {
		super();
		this.id = id;
		this.gender = gender;
		this.experiance = experiance;
		this.qualification = qualification;
		this.consultationFee = consultationFee;
		this.scheduleList = scheduleList;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * @return the experiance
	 */
	public String getExperiance() {
		return experiance;
	}
	/**
	 * @param experiance the experiance to set
	 */
	public void setExperiance(String experiance) {
		this.experiance = experiance;
	}
	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	/**
	 * @return the consultationFee
	 */
	public double getConsultationFee() {
		return consultationFee;
	}
	/**
	 * @param consultationFee the consultationFee to set
	 */
	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}
	/**
	 * @return the scheduleList
	 */
	public List<ScheduleModel> getScheduleList() {
		return scheduleList;
	}
	/**
	 * @param scheduleList the scheduleList to set
	 */
	public void setScheduleList(List<ScheduleModel> scheduleList) {
		this.scheduleList = scheduleList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoctorDetailsModel [id=");
		builder.append(id);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", experiance=");
		builder.append(experiance);
		builder.append(", qualification=");
		builder.append(qualification);
		builder.append(", consultationFee=");
		builder.append(consultationFee);
		builder.append(", scheduleList=");
		builder.append(scheduleList);
		builder.append("]");
		return builder.toString();
	}		
}
