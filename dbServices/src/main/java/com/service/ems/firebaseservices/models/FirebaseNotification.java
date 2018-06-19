package com.service.ems.firebaseservices.models;

public class FirebaseNotification {
	private int notificationId;

	public FirebaseNotification(int notificationId) {
		super();
		this.notificationId = notificationId;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

}
