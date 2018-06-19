package com.service.ems.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ems.services.AppointmentBookService;

@RestController
public class AppointmentBookController {
	
	@Autowired
	AppointmentBookService appointmentBookService;
	
	@PutMapping("/appointment/select/{hospitalId}/{doctorId}/{scheduleId}")
	public ResponseEntity<String> selectAppointment(@PathVariable long hospitalId, @PathVariable long doctorId, @PathVariable long scheduleId) {
		
		String response = appointmentBookService.selectAppointment(hospitalId, doctorId, scheduleId);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/appointment/book/{hospitalId}/{doctorId}/{scheduleId}")
	public ResponseEntity<String> bookAppointment(@PathVariable long hospitalId, @PathVariable long doctorId, @PathVariable long scheduleId) {
		
		String response = appointmentBookService.bookAppointment(hospitalId, doctorId, scheduleId);	
		return ResponseEntity.ok(response);
	}

}
