package com.service.ems.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.service.ems.constants.Gender;
import com.service.ems.models.AppointmentSearchRequestModel;
import com.service.ems.models.AppointmentSearchResponseModel;
import com.service.ems.models.DoctorDetailsModel;
import com.service.ems.models.GeoLocationModel;
import com.service.ems.models.HospitalDetailsModel;
import com.service.ems.models.ScheduleModel;

@Service
public class AppointmentSearchServiceImpl implements AppointmentSearchService{
	
	List<ScheduleModel> scheduleList = new ArrayList<>(
			Arrays.asList(
//					new ScheduleModel((long)1, LocalDate.now(), LocalTime.now(), "Duration1", true),
//					new ScheduleModel((long)2, LocalDate.now(),LocalTime.now(), "Duration2", true),
					new ScheduleModel((long)3, LocalDate.now(),LocalTime.now(), "Duration3", true)
					)
			);
	
	List<DoctorDetailsModel> doctorsList = new ArrayList<>(
			Arrays.asList(
//					new DoctorDetailsModel((long)1, Gender.MALE, "experiance1", "MBBS", 250, scheduleList),
//					new DoctorDetailsModel((long)2, Gender.MALE, "experiance2", "MBBS", 250, scheduleList),
					new DoctorDetailsModel((long)3, Gender.MALE, "experiance3", "MBBS", 250, scheduleList)
					)			
			);
	
	GeoLocationModel geoLocationModel = new GeoLocationModel("longitude", "latitude");
	
	List<HospitalDetailsModel> hospitalList = new ArrayList<>(
			Arrays.asList(
//					new HospitalDetailsModel((long)1, "Appollo1", geoLocationModel, "cancelationPolicy",  doctorsList),
//					new HospitalDetailsModel((long)2, "Appollo2", geoLocationModel, "cancelationPolicy",  doctorsList),
					new HospitalDetailsModel((long)3, "Appollo3", geoLocationModel, "cancelationPolicy",  doctorsList)
					)
			);
	

	AppointmentSearchResponseModel appointmentSearchResponseModel = new AppointmentSearchResponseModel(hospitalList);
	
	@Override
	public AppointmentSearchResponseModel searchAppointment(AppointmentSearchRequestModel appointmentSearchRequestModel) {
		
		return appointmentSearchResponseModel;
	}	
		
}
