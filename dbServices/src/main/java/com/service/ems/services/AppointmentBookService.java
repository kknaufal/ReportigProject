package com.service.ems.services;


public interface AppointmentBookService {

	String selectAppointment(long hospitalId, long doctorId, long scheduleId);

	String bookAppointment(long hospitalId, long doctorId, long scheduleId);
	

}
