package com.service.ems.models;

import java.util.List;

public class HospitalDetailsModel {
	
	private long id;
	private String name;
	private GeoLocationModel geoLocationModel;
	private String cancelationPolicy;
	List<DoctorDetailsModel> doctorsList;
	
	/**
	 * 
	 */
	public HospitalDetailsModel() {
		super();
	}	
	/**
	 * @param id
	 * @param name
	 * @param geoLocationModel
	 * @param cancelationPolicy
	 * @param doctorsList
	 */
	public HospitalDetailsModel(long id, String name, GeoLocationModel geoLocationModel, String cancelationPolicy,
			List<DoctorDetailsModel> doctorsList) {
		super();
		this.id = id;
		this.name = name;
		this.geoLocationModel = geoLocationModel;
		this.cancelationPolicy = cancelationPolicy;
		this.doctorsList = doctorsList;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}	
	/**
	 * @return the geoLocationModel
	 */
	public GeoLocationModel getGeoLocation() {
		return geoLocationModel;
	}
	/**
	 * @param geoLocationModel the geoLocationModel to set
	 */
	public void setGeoLocation(GeoLocationModel geoLocationModel) {
		this.geoLocationModel = geoLocationModel;
	}
	/**
	 * @return the cancelationPolicy
	 */
	public String getCancelationPolicy() {
		return cancelationPolicy;
	}
	/**
	 * @param cancelationPolicy the cancelationPolicy to set
	 */
	public void setCancelationPolicy(String cancelationPolicy) {
		this.cancelationPolicy = cancelationPolicy;
	}
	/**
	 * @return the doctorsList
	 */
	public List<DoctorDetailsModel> getDoctorsList() {
		return doctorsList;
	}
	/**
	 * @param doctorsList the doctorsList to set
	 */
	public void setDoctorsList(List<DoctorDetailsModel> doctorsList) {
		this.doctorsList = doctorsList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HospitalDetailsModel [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", geoLocationModel=");
		builder.append(geoLocationModel);
		builder.append(", cancelationPolicy=");
		builder.append(cancelationPolicy);
		builder.append(", doctorsList=");
		builder.append(doctorsList);
		builder.append("]");
		return builder.toString();
	}
}
