package com.service.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.ems.domain.Practice;
import com.service.ems.models.AppointmentSearchModel;
import com.service.ems.models.AppointmentSearchRequestModel;
import com.service.ems.models.AppointmentSearchResponseModel;
import com.service.ems.models.PracticeModel;
import com.service.ems.services.AppointmentSearchService;
import com.service.ems.services.PracticeService;

@RestController
public class AppointmentSearchController {
	
	@Autowired
	private PracticeService practiceService;
	
	@Autowired
	private AppointmentSearchService appointmentSearchService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/appointment/search1")
	public ResponseEntity<AppointmentSearchResponseModel> searchAppointment(@RequestBody AppointmentSearchRequestModel appointmentSearchRequestModel){
		
		AppointmentSearchResponseModel appointmentSearchResponseModel = appointmentSearchService.searchAppointment(appointmentSearchRequestModel);		
		return ResponseEntity.ok(appointmentSearchResponseModel);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/appointment/search")
	public ResponseEntity<List<Practice>> searchAppointment(@RequestBody AppointmentSearchModel appointmentSearchModel){
		List<Practice> response =  practiceService.getSearchAppointment(appointmentSearchModel);		
		return ResponseEntity.ok(response);
	}

}


