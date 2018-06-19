package com.service.ems.firebaseservices;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.service.ems.firebase.FirebaseHandler;

@Service
public class FirebaseServiceImpl implements FirebaseService {

	@Override
	public void insertNotificaitons(Map<String, Object> notifications) {
		FirebaseHandler.insertNotifications(notifications);

	}

}
