package com.service.ems.models;

import java.sql.Date;
import java.util.List;

public class DoctorScheduleRequestModel {
	
	private Date startDate;
	private Date endDate;
	private long doctorId;
	private List<String> days;
	/**
	 * 
	 */
	public DoctorScheduleRequestModel() {
		super();
	}
	
	/**
	 * @param startDate
	 * @param endDate
	 * @param doctorId
	 * @param days
	 */
	public DoctorScheduleRequestModel(Date startDate, Date endDate, long doctorId, List<String> days) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.doctorId = doctorId;
		this.days = days;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @return the days
	 */
	public List<String> getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(List<String> days) {
		this.days = days;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoctorScheduleRequestModel [startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", doctorId=");
		builder.append(doctorId);
		builder.append(", days=");
		builder.append(days);
		builder.append("]");
		return builder.toString();
	}
	
}
