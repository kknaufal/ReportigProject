package com.service.ems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.ems.models.DoctorScheduleRequestModel;
import com.service.ems.models.DoctorScheduleResponseModel;
import com.service.ems.services.DoctorScheduleService;

@RestController
public class DoctorScheduleController {
	
	@Autowired
	DoctorScheduleService doctorScheduleService;
	
	@PostMapping("/doctor/schedule")
	ResponseEntity<DoctorScheduleResponseModel> getDoctorSchedule(@RequestBody DoctorScheduleRequestModel doctorScheduleRequest){
				
		DoctorScheduleResponseModel doctorScheduleResponseModel = null;
		ResponseEntity<DoctorScheduleResponseModel> responseEntity = null;
		
		doctorScheduleResponseModel = doctorScheduleService.getDoctorSchedule(doctorScheduleRequest);
		
		if(doctorScheduleResponseModel != null) {
			
			responseEntity = ResponseEntity.ok(doctorScheduleResponseModel);
		}else {
			
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return responseEntity;
	}	
}
