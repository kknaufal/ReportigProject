package com.service.ems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.ems.models.NotificationModel;
import com.service.ems.services.NotificationService;

@RestController
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@GetMapping("/notifications/{userId}/{notificationId}")
	public ResponseEntity<NotificationModel> getNotification(@PathVariable  long userId, @PathVariable long notificationId) {
		
		NotificationModel notificationModel = null;
		
		notificationModel = notificationService.getNotification(userId, notificationId);
		if(notificationModel == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(notificationModel);
		
	}
	
	@PostMapping("/notification")
	public ResponseEntity<NotificationModel> addNotification(@RequestBody NotificationModel notificationModel) {
		
		NotificationModel savedNotification;
		savedNotification = notificationService.addNotification(notificationModel);
		return ResponseEntity.ok(savedNotification);
	}
	
}


