package com.service.ems.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.service.ems.domain.Address;
import com.service.ems.domain.Doctor;
import com.service.ems.domain.InsurancePolicy;
import com.service.ems.domain.Speciality;
import com.vividsolutions.jts.geom.Point;

@JsonIgnoreProperties(value = {"insurancePolicies", "address", "geom", "doctors"}, 
allowGetters = false)
public class PracticeModel {

	private Long id;
	
	private String name;
	
	private List<Address> address;
	
	private Long phone;
	
	private String email;
	
	private String contactPerson;
	
	private String contactEmail;
	
	private Long contactPhone;
	
	private List<Speciality> specialities;
	
	private List<InsurancePolicy> insurancePolicies;
	
	private Long feesToEms;
	
	private Long appointmentReminderPeriod;
	
	private int cancelationPeriodDays;
	
	private int cancelationPeriodHours;
	
	private int cancelationPeriodMinutes;
	
	private Long cancelationFees;
	
	private Long PhysicianCancelationFeeToUser;
	
	private String contratSubscriptionLevel;
	
	private String initiatePeriodicSweep;
	
	private String periodicSweep;
	
	private Long bankRoutingNo;
	
	private Long bankAccountNo;
	
	private Boolean inactive;
	
	private List<Doctor> doctors;

	private Double lat;

	private Double lon;

	private Point geom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Long getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(Long contactPhone) {
		this.contactPhone = contactPhone;
	}

	public List<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<Speciality> specialities) {
		this.specialities = specialities;
	}

	public List<InsurancePolicy> getInsurancePolicies() {
		return insurancePolicies;
	}

	public void setInsurancePolicies(List<InsurancePolicy> insurancePolicies) {
		this.insurancePolicies = insurancePolicies;
	}

	public Long getFeesToEms() {
		return feesToEms;
	}

	public void setFeesToEms(Long feesToEms) {
		this.feesToEms = feesToEms;
	}

	public Long getAppointmentReminderPeriod() {
		return appointmentReminderPeriod;
	}

	public void setAppointmentReminderPeriod(Long appointmentReminderPeriod) {
		this.appointmentReminderPeriod = appointmentReminderPeriod;
	}

	public int getCancelationPeriodDays() {
		return cancelationPeriodDays;
	}

	public void setCancelationPeriodDays(int cancelationPeriodDays) {
		this.cancelationPeriodDays = cancelationPeriodDays;
	}

	public int getCancelationPeriodHours() {
		return cancelationPeriodHours;
	}

	public void setCancelationPeriodHours(int cancelationPeriodHours) {
		this.cancelationPeriodHours = cancelationPeriodHours;
	}

	public int getCancelationPeriodMinutes() {
		return cancelationPeriodMinutes;
	}

	public void setCancelationPeriodMinutes(int cancelationPeriodMinutes) {
		this.cancelationPeriodMinutes = cancelationPeriodMinutes;
	}

	public Long getCancelationFees() {
		return cancelationFees;
	}

	public void setCancelationFees(Long cancelationFees) {
		this.cancelationFees = cancelationFees;
	}

	public Long getPhysicianCancelationFeeToUser() {
		return PhysicianCancelationFeeToUser;
	}

	public void setPhysicianCancelationFeeToUser(Long physicianCancelationFeeToUser) {
		PhysicianCancelationFeeToUser = physicianCancelationFeeToUser;
	}

	public String getContratSubscriptionLevel() {
		return contratSubscriptionLevel;
	}

	public void setContratSubscriptionLevel(String contratSubscriptionLevel) {
		this.contratSubscriptionLevel = contratSubscriptionLevel;
	}

	public String getInitiatePeriodicSweep() {
		return initiatePeriodicSweep;
	}

	public void setInitiatePeriodicSweep(String initiatePeriodicSweep) {
		this.initiatePeriodicSweep = initiatePeriodicSweep;
	}

	public String getPeriodicSweep() {
		return periodicSweep;
	}

	public void setPeriodicSweep(String periodicSweep) {
		this.periodicSweep = periodicSweep;
	}

	public Long getBankRoutingNo() {
		return bankRoutingNo;
	}

	public void setBankRoutingNo(Long bankRoutingNo) {
		this.bankRoutingNo = bankRoutingNo;
	}

	public Long getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(Long bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Point getGeom() {
		return geom;
	}

	public void setGeom(Point geom) {
		this.geom = geom;
	}


}
