package com.service.ems.services;


import com.service.ems.models.AppointmentSearchRequestModel;
import com.service.ems.models.AppointmentSearchResponseModel;

public interface AppointmentSearchService {

	public AppointmentSearchResponseModel searchAppointment(AppointmentSearchRequestModel appointmentSearchRequestModel);
	
}
