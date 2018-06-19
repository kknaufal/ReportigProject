package com.service.ems.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.service.ems.constants.DoctorScheduleStatus;

@Entity
@Table(name = "DOCTOR_SCHEDULE")
public class DoctorScheduleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="DOCTOR_ID")
	private long doctorId;		
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="START_TIME")
	private Time startTime;
		
	@Column(name="DURATION")
	private double duration;
	
	@Column(name="STATUS")
	private DoctorScheduleStatus status;

	/**
	 * 
	 */
	public DoctorScheduleModel() {
		super();
	}

	/**
	 * @param id
	 * @param doctorId
	 * @param date
	 * @param startTime
	 * @param duration
	 * @param status
	 */
	public DoctorScheduleModel(long id, long doctorId, Date date, Time startTime, double duration,
			DoctorScheduleStatus status) {
		super();
		this.id = id;
		this.doctorId = doctorId;
		this.date = date;
		this.startTime = startTime;
		this.duration = duration;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the startTime
	 */
	public Time getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the status
	 */
	public DoctorScheduleStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(DoctorScheduleStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoctorScheduleModel [id=");
		builder.append(id);
		builder.append(", doctorId=");
		builder.append(doctorId);
		builder.append(", date=");
		builder.append(date);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}	
}
