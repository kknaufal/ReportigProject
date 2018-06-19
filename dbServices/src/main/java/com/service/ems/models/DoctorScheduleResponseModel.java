package com.service.ems.models;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class DoctorScheduleResponseModel {
	
	private long doctorId;
	private Set<DoctorScheduleDate>  scheduleDateSet;
	
	/**
	 * 
	 */
	public DoctorScheduleResponseModel() {
		super();
	}
	/**
	 * @param doctorId
	 * @param scheduleDate
	 */
	public DoctorScheduleResponseModel(long doctorId, Set<DoctorScheduleDate> scheduleDateSet) {
		super();
		this.doctorId = doctorId;
		this.scheduleDateSet = scheduleDateSet;
	}
	
	public void addDoctorScheduleDate(DoctorScheduleDate doctorScheduleDate) {
		
		if(scheduleDateSet == null) {
			scheduleDateSet = new HashSet<>();			
		}
		scheduleDateSet.add(doctorScheduleDate);
		
	}
	/**
	 * @return the doctorId
	 */
	public long getDoctorId() {
		return doctorId;
	}
	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * @return the scheduleDate
	 */
	public Set<DoctorScheduleDate> getScheduleDateSet() {
		return scheduleDateSet;
	}
	/**
	 * @param scheduleDate the scheduleDate to set
	 */
	public void setScheduleDateSet(Set<DoctorScheduleDate> scheduleDateSet) {
		this.scheduleDateSet = scheduleDateSet;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoctorScheduleResponseModel [doctorId=");
		builder.append(doctorId);
		builder.append(", scheduleDate=");
		builder.append(scheduleDateSet);
		builder.append("]");
		return builder.toString();
	}
}
