package com.service.ems.firebaseservices.models;

public class User {

	private FirebaseNotification notification;

	public User(FirebaseNotification notification) {
		super();
		this.notification = notification;
	}

	public FirebaseNotification getNotification() {
		return notification;
	}

	public void setNotification(FirebaseNotification notification) {
		this.notification = notification;
	}

}
