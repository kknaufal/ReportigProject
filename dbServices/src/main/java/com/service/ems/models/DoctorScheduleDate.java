package com.service.ems.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

public class DoctorScheduleDate {
	
	private Date date;
	private Set<Time> slots;

	/**
	 * 
	 */
	public DoctorScheduleDate() {
		super();
	}

	/**
	 * @param date
	 * @param slots
	 */
	public DoctorScheduleDate(Date date, Set<Time> slots) {
		super();
		this.date = date;
		this.slots = slots;
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
	 * @return the slots
	 */
	public Set<Time> getSlots() {
		return slots;
	}

	/**
	 * @param slots the slots to set
	 */
	public void setSlots(Set<Time> slots) {
		this.slots = slots;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoctorScheduleDate [slots=");
		builder.append(slots);
		builder.append("]");
		return builder.toString();
	}
	
}
