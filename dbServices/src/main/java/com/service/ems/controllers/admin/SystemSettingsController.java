package com.service.ems.controllers.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.ems.models.SystemSettingsModel;
import com.service.ems.services.SystemSettingsService;

@RestController
public class SystemSettingsController {
	
	@Autowired
	SystemSettingsService systemSettingsService;
	
	@PostMapping("/system/settings")
	public ResponseEntity<SystemSettingsModel> saveSystemSettings(@RequestBody SystemSettingsModel systemSettingsModel){
		
		SystemSettingsModel savedSystemSettings = null;
		savedSystemSettings = systemSettingsService.saveSystemSettings(systemSettingsModel);
		if(savedSystemSettings != null) {
			return ResponseEntity.ok(savedSystemSettings);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@GetMapping("/system/settings/{settingId}")
	public ResponseEntity<SystemSettingsModel> getSystemSettings(@PathVariable long settingId){
		
		SystemSettingsModel systemSettingsModel = null;
		
		systemSettingsModel = systemSettingsService.getSystemSettings(settingId);
		if(systemSettingsModel != null ) {
			return ResponseEntity.ok(systemSettingsModel);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@PutMapping("/system/settings")
	public ResponseEntity<SystemSettingsModel> updateSystemSettings(@RequestBody SystemSettingsModel systemSettingsModel){
		
		SystemSettingsModel updatedSystemSettings = null;		
		updatedSystemSettings = systemSettingsService.updateSystemSettings(systemSettingsModel);
		
		if(updatedSystemSettings != null) {
			return ResponseEntity.ok(updatedSystemSettings);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
	}
}
