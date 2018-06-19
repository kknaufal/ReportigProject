package com.service.ems.models;

import java.util.Date;

import com.service.ems.constants.Gender;

public class AppointmentSearchRequestModel {
	
	String gpsLocation;
	String specialty;
	Date fromDate;
	Date toDate;
	double doctorFee;
	Gender gender;
	double distance;
	
	
	/**
	 * 
	 */
	public AppointmentSearchRequestModel() {
		super();
	}
	
	/**
	 * @param gpsLocation
	 * @param specialty
	 * @param fromDate
	 * @param toDate
	 * @param doctorFee
	 * @param gender
	 * @param distance
	 */
	public AppointmentSearchRequestModel(String gpsLocation, String speciality, Date fromDate, Date toDate, double doctorFee,
			Gender gender, double distance) {
		super();
		this.gpsLocation = gpsLocation;
		this.specialty = speciality;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.doctorFee = doctorFee;
		this.gender = gender;
		this.distance = distance;
	}
	/**
	 * @return the gpsLocation
	 */
	public String getGpsLocation() {
		return gpsLocation;
	}
	/**
	 * @param gpsLocation the gpsLocation to set
	 */
	public void setGpsLocation(String gpsLocation) {
		this.gpsLocation = gpsLocation;
	}
	/**
	 * @return the specialty
	 */
	public String getSpeciality() {
		return specialty;
	}
	/**
	 * @param speciality the specialty to set
	 */
	public void setSpeciality(String specialty) {
		this.specialty = specialty;
	}
	
	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}	
	/**
	 * @return the doctorFee
	 */
	public double getDoctorFee() {
		return doctorFee;
	}

	/**
	 * @param doctorFee the doctorFee to set
	 */
	public void setDoctorFee(double doctorFee) {
		this.doctorFee = doctorFee;
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
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppointmentSearchRequestModel [gpsLocation=" + gpsLocation + ", specialty=" + specialty + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", doctorFee=" + doctorFee + ", gender=" + gender + ", distance="
				+ distance + "]";
	}		
	
	
}
