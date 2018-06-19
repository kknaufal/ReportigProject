package com.service.ems.models;

import java.util.List;

public class AppointmentSearchResponseModel {
	
	List<HospitalDetailsModel> hospitalist; 

	/**
	 * 
	 */
	public AppointmentSearchResponseModel() {
		super();
	}

	/**
	 * @param doctors
	 */
	public AppointmentSearchResponseModel(List<HospitalDetailsModel> hospitalist) {
		super();
		this.hospitalist = hospitalist;
	}

	/**
	 * @return the hospitalist
	 */
	public List<HospitalDetailsModel> getHospitalist() {
		return hospitalist;
	}

	/**
	 * @param hospitalist the hospitalist to set
	 */
	public void setHospitalist(List<HospitalDetailsModel> hospitalist) {
		this.hospitalist = hospitalist;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppointmentSearchResponseModel [hospitalist=");
		builder.append(hospitalist);
		builder.append("]");
		return builder.toString();
	}
}
