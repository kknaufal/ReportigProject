package com.service.ems.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.ems.models.HospitalDetailsModel;

@Service
public class AppointmentBookServiceImpl implements AppointmentBookService {

	List<HospitalDetailsModel> hospitalList; 

	@Override
	public String selectAppointment(long hospitalId, long doctorId, long scheduleId) {
				
		String response = "schedule is on hold";
		return response;
	}

	@Override
	public  String bookAppointment(long hospitalId, long doctorId, long scheduleId) {
		String response = "schedule booked";
		return response;
	}
	
	

}
