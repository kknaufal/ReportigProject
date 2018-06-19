package com.service.ems.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.vividsolutions.jts.geom.Point;

import java.util.List;


/**
 * The persistent class for the practice database table.
 * 
 */
@Entity
@NamedQuery(name="Practice.findAll", query="SELECT p FROM Practice p")
public class Practice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy="practice")
	private List<Address> address;

	@Column(name="appointment_reminder_period", nullable=true)
	private Long appointmentReminderPeriod;

	@Column(name="bank_account_no", nullable=true)
	private Long bankAccountNo;

	@Column(name="bank_routing_no", nullable=true)
	private Long bankRoutingNo;

	@Column(name="cancelation_fees", nullable=true)
	private Long cancelationFees;

	@Column(name="cancelation_period_days", nullable=true)
	private Integer cancelationPeriodDays;

	@Column(name="cancelation_period_hours", nullable=true)
	private Integer cancelationPeriodHours;

	@Column(name="cancelation_period_minutes", nullable=true)
	private Integer cancelationPeriodMinutes;

	@Column(name="contact_email", nullable=true)
	private String contactEmail;

	@Column(name="contact_person", nullable=true)
	private String contactPerson;

	@Column(name="contact_phone", nullable=true)
	private Long contactPhone;

	@Column(name="contrat_subscription_level", nullable=true)
	private String contratSubscriptionLevel;

	private String email;

	@Column(name="fees_to_ems", nullable=true)
	private Long feesToEms;

	private Boolean inactive;

	@Column(name="initiate_periodic_sweep", nullable=true)
	private String initiatePeriodicSweep;

	private String name;

	@Column(name="periodic_sweep", nullable=true)
	private String periodicSweep;

	private Long phone;

	@Column(name="physician_cancelation_fee_to_user", nullable=true)
	private Long physicianCancelationFeeToUser;

	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="practice")
	private List<Doctor> doctors;

	//bi-directional many-to-many association to InsurancePolicy
	@ManyToMany
	@JoinTable(
		name="practice_insurance"
		, joinColumns={
			@JoinColumn(name="insurance_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="practice_id")
			}
		)
	private List<InsurancePolicy> insurancePolicies;

	//bi-directional many-to-many association to Speciality
	@ManyToMany
	@JoinTable(
		name="practice_speciality"
		, joinColumns={
			@JoinColumn(name="speciality_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="practice_id")
			}
		)
	private List<Speciality> specialities;
	
	@Column(name = "lat")
	private Double lat;

	@Column(name = "lon")
	private Double lon;

	//@Column(name = "geom",columnDefinition="Point")
	@Column(columnDefinition = "geometry", nullable = true) 
    private Point geom;

	public Practice() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Long getAppointmentReminderPeriod() {
		return this.appointmentReminderPeriod;
	}

	public void setAppointmentReminderPeriod(Long appointmentReminderPeriod) {
		this.appointmentReminderPeriod = appointmentReminderPeriod;
	}

	public Long getBankAccountNo() {
		return this.bankAccountNo;
	}

	public void setBankAccountNo(Long bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public Long getBankRoutingNo() {
		return this.bankRoutingNo;
	}

	public void setBankRoutingNo(Long bankRoutingNo) {
		this.bankRoutingNo = bankRoutingNo;
	}

	public Long getCancelationFees() {
		return this.cancelationFees;
	}

	public void setCancelationFees(Long cancelationFees) {
		this.cancelationFees = cancelationFees;
	}

	public Integer getCancelationPeriodDays() {
		return this.cancelationPeriodDays;
	}

	public void setCancelationPeriodDays(Integer cancelationPeriodDays) {
		this.cancelationPeriodDays = cancelationPeriodDays;
	}

	public Integer getCancelationPeriodHours() {
		return this.cancelationPeriodHours;
	}

	public void setCancelationPeriodHours(Integer cancelationPeriodHours) {
		this.cancelationPeriodHours = cancelationPeriodHours;
	}

	public Integer getCancelationPeriodMinutes() {
		return this.cancelationPeriodMinutes;
	}

	public void setCancelationPeriodMinutes(Integer cancelationPeriodMinutes) {
		this.cancelationPeriodMinutes = cancelationPeriodMinutes;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Long getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(Long contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContratSubscriptionLevel() {
		return this.contratSubscriptionLevel;
	}

	public void setContratSubscriptionLevel(String contratSubscriptionLevel) {
		this.contratSubscriptionLevel = contratSubscriptionLevel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getFeesToEms() {
		return this.feesToEms;
	}

	public void setFeesToEms(Long feesToEms) {
		this.feesToEms = feesToEms;
	}

	public Boolean getInactive() {
		return this.inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	public String getInitiatePeriodicSweep() {
		return this.initiatePeriodicSweep;
	}

	public void setInitiatePeriodicSweep(String initiatePeriodicSweep) {
		this.initiatePeriodicSweep = initiatePeriodicSweep;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriodicSweep() {
		return this.periodicSweep;
	}

	public void setPeriodicSweep(String periodicSweep) {
		this.periodicSweep = periodicSweep;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getPhysicianCancelationFeeToUser() {
		return this.physicianCancelationFeeToUser;
	}

	public void setPhysicianCancelationFeeToUser(Long physicianCancelationFeeToUser) {
		this.physicianCancelationFeeToUser = physicianCancelationFeeToUser;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setPractice(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setPractice(null);

		return doctor;
	}

	public List<InsurancePolicy> getInsurancePolicies() {
		return this.insurancePolicies;
	}

	public void setInsurancePolicies(List<InsurancePolicy> insurancePolicies) {
		this.insurancePolicies = insurancePolicies;
	}

	public List<Speciality> getSpecialities() {
		return this.specialities;
	}

	public void setSpecialities(List<Speciality> specialities) {
		this.specialities = specialities;
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