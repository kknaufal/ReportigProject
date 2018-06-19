package com.service.ems.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the doctor_schedule database table.
 * 
 */
@Entity
@Table(name="doctor_schedule")
@NamedQuery(name="DoctorSchedule.findAll", query="SELECT d FROM DoctorSchedule d")
public class DoctorSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int duration;

	@Temporal(TemporalType.DATE)
	@Column(name="schedule_date")
	private Date scheduleDate;

	@Column(name="start_time")
	private Double startTime;

	private String status;

	//bi-directional many-to-one association to Doctor
	@ManyToOne(fetch=FetchType.LAZY)
	private Doctor doctor;

	public DoctorSchedule() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Double getStartTime() {
		return startTime;
	}

	public void setStartTime(Double startTime) {
		this.startTime = startTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
}