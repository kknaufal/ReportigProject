package com.service.ems.constants;

public enum DoctorScheduleStatus {
	
	BOOKED("BOOKED", 0), AVAILABLE("AVAILABLE", 1);
	
	private final String status;
	private final int statudCode;
	/**
	 * @param status
	 * @param statudCode
	 */
	private DoctorScheduleStatus(String status, int statudCode) {
		this.status = status;
		this.statudCode = statudCode;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the statudCode
	 */
	public int getStatudCode() {
		return statudCode;
	}
	
	

}
