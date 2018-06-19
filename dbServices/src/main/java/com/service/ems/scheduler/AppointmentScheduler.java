package com.service.ems.scheduler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.service.ems.firebaseservices.FirebaseService;
import com.service.ems.firebaseservices.models.FirebaseNotification;
import com.service.ems.firebaseservices.models.User;
import com.service.ems.models.NotificationModel;
import com.service.ems.services.NotificationService;

@Service
public class AppointmentScheduler {

	@Autowired
	NotificationService notificationService;
	@Autowired
	FirebaseService firebaseService;

	public void insertNotification() {
		int userId = findUserId();
		NotificationModel dbNotification = buildDBNotification(userId, "New Appointment Created", "UNREAD");
		dbNotification = notificationService.addNotification(dbNotification);
		Map<String, Object> notifications = buildFirebaseNotification(userId, (int) dbNotification.getNotificationId());
		firebaseService.insertNotificaitons(notifications);

	}

	private NotificationModel buildDBNotification(int userId, String notificationMsg, String notificationStatus) {
		NotificationModel notificationModel = new NotificationModel(userId, notificationMsg, notificationStatus);

		return notificationModel;
	}

	private Map<String, Object> buildFirebaseNotification(int userId, int notificationId) {
		Map<String, Object> notifications = new HashMap<String, Object>();
		FirebaseNotification notification = new FirebaseNotification(notificationId);
		User user = new User(notification);

		notifications.put(String.valueOf(userId), user);
		return notifications;

	}

	private int findUserId() {
		int userId = 7;
		return userId;

	}

}
