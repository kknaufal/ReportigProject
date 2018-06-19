package com.service.ems.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private double experience;

	private double fees;

	private String gender;

	private String name;

	private String qualification;
	
	
    private byte[] image;

	//bi-directional many-to-one association to DoctorSchedule
	@OneToMany(mappedBy="doctor")
	private List<DoctorSchedule> doctorSchedules;

	//bi-directional many-to-one association to Practice
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="practice_id")
	private Practice practice;

	public Doctor() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getExperience() {
		return this.experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public double getFees() {
		return this.fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public List<DoctorSchedule> getDoctorSchedules() {
		return this.doctorSchedules;
	}

	public void setDoctorSchedules(List<DoctorSchedule> doctorSchedules) {
		this.doctorSchedules = doctorSchedules;
	}

	public DoctorSchedule addDoctorSchedule(DoctorSchedule doctorSchedule) {
		getDoctorSchedules().add(doctorSchedule);
		doctorSchedule.setDoctor(this);

		return doctorSchedule;
	}

	public DoctorSchedule removeDoctorSchedule(DoctorSchedule doctorSchedule) {
		getDoctorSchedules().remove(doctorSchedule);
		doctorSchedule.setDoctor(null);

		return doctorSchedule;
	}

	@JsonIgnore
	public Practice getPractice() {
		return this.practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}