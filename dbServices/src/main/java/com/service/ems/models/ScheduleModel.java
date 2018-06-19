package com.service.ems.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleModel {
	
	private Long id;
	private LocalDate date;
	private LocalTime startTime;
	private String duration;
	private boolean isAvailable;
	/**
	 * 
	 */
	public ScheduleModel() {
		super();
	}
	/**
	 * @param id
	 * @param date
	 * @param startTime
	 * @param duration
	 * @param isAvailable
	 */
	public ScheduleModel(Long id, LocalDate date, LocalTime startTime, String duration, boolean isAvailable) {
		super();
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.duration = duration;
		this.isAvailable = isAvailable;
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
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the startTime
	 */
	public LocalTime getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduleModel [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", isAvailable=");
		builder.append(isAvailable);
		builder.append("]");
		return builder.toString();
	}				
}
